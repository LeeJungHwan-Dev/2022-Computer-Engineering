/**
 * @file server.c
 * @author 이정환 (leeejh@jbnu.ac.kr) / 201812163
 * @brief 
 * 
 * 이 서버는 과제에 올라온 클라이언트 소스 코드를 바탕으로 제작하였습니다.
 * 
 * @version 0.1
 * @date 2022-10-03
 * 
 * @copyright Copyright (c) 2022
 * 
 */




#define  BSD //MacOs에서 실험하기 때문에 유닉스 계열 BSD 사용

//----- Include files ---------------------------------------------------------
#include <stdio.h>          
#include <string.h>         
#ifdef WIN
  #include <windows.h>      
#endif
#ifdef BSD
  #include <sys/types.h>    // socket bind를 위한 헤더 파일
  #include <netinet/in.h>   
  #include <sys/socket.h>   // socket bind를 위한 헤더 파일
  #include <arpa/inet.h>    // arpa또는 inet.h 하나만 넣어줘도 된다. 이는 2개를 전부 선택한거다.
  #include <fcntl.h>
  #include <netdb.h>
  #include <unistd.h>       // 오류 해결을 위해 추가함
#endif

//----- Defines ---------------------------------------------------------------
#define  PORT_NUM         1050     // 서버 연결에 사용할 포트
#define  IP_ADDR "127.0.0.1"       // 서버 연결에 사용할 IP

//===== Main program ==========================================================

unsigned int         server_sock; // 서버 소켓 상태를 저장하기 위한 변수 (디스크립터)
unsigned int         client_sock; // 클라이언트 소켓 상태를 저장하기 위한 변수 (디스크립터)
struct sockaddr_in   server_addr; // 서버 소켓의 주소를 담을 server_addr 변수 // AF_INET을 사용하기 때문
struct sockaddr_in   client_addr; // 클라이언트 소켓의 주소를 담을 client_addr 변수

// sockaddr_in은 IPv4 주소를 저장하는 구조체이다.
// 우리는 이번 실습에서 IPv4를 사용할 것이기때문에 sockaddr_in을 사용했다.

socklen_t            client_size;

/** 
 * 
 * accept 당시 addr에 전달된 주소 변수의 크기를 바이트 단위로 전달하기 
 * 때문에 클라이언트 사이즈를 저장 하기 위한 변수
 * 
 */

char                 out_buf[100]; // 전송할 데이터를 담을 버퍼
char                 in_buf[100];  // 받을 데이터를 담을 버퍼



int main(void) // 에러 코드나와서 void main에서 int main으로 수정함
{

  server_sock = server_addr.sin_family = AF_INET;
  //sin_family는 주소체계를 저장하는 필드이다.

  server_addr.sin_addr.s_addr = inet_addr(IP_ADDR);
  //s_addr는 ip주소를 저장하는 구조체이다.

  server_addr.sin_port = htons(PORT_NUM);
  //sin_port는 포트 정보를 저장하는 값 입니다.


  server_sock = socket(AF_INET,SOCK_STREAM,0);

  /**
   * socket() 함수?
   * int socket(int domain, int type, int protocol);
   * 
   * 소켓 함수는 도메인 , 타입 , 프로토콜 순으로 기록한다.
   * 
   * 첫번째로 도메인은 어떤 영역에서 통신 할 건지 지정해주는 것이다. 
   * 
   * AF_UNIX : 프로세스간 통신을 위해 사용된다
   * AF_INET : 물리적으로 분리된 컴퓨터간 통신에 사용되는 IPv4 통신이다.
   * 
   * 
   * 두번째로 타입은 어떤 타입의 프로토콜을 사용할 것인지 알려준다.
   * 
   * SOCK_STREAM : TCP/IP를 사용한다.
   * SOCK_DGRAM : UDP를 사용한다.
   * SOCKRWA : 사용자가 직접 정의한 규약을 사용한다.
   * 
   * 세번째는 프로토콜의 값을 결정하는 것으로 보통 0을 기록한다.
   * 
   * 0 : 기본값 사용
   * IPPROTO_TCP : AF_INET과 SOCK_STREAM 유형과 사용된다.
   * IPPROTO_UDP : AF_UNIX와 SOCK_DGRAM 유형과 사용된다.
   * 
   * 즉, 위의 소켓 인자 값을 보면 IPv4, TCP, 0 을 사용해서 소켓을 생성해달라.
   * 라는 뜻으로 해석할 수 있다.
   * 
   */


  bind(server_sock,(struct sockaddr *)&server_addr, sizeof(server_addr));

  /**
   * bind() 함수?
   * bind는 만들어진 빈 소켓에 IP와 포트 번호를 지정해주는 함수이다.
   * 
   * 첫번째는 서버 소켓의 디스크립터 정보를 넘겨준다.
   * 두번째는 할당하고자 하는 주소 정보를 가진 server_addr의 값을 넘겨준다.
   * 세번째는 두번째 인자 값으로 전달된 server_addr의 사이즈 값을 넘겨준다.
   * 
   */


  bzero(&server_addr,sizeof(server_addr));

  /**
   * bzero() ?
   * 
   * 0x00 값을 첫번째 인자 값 영역에 , 두번째 인자값 사이즈 만큼 초기화한다.
   * 할당 받은 server_addr를 0으로 초기화 해준다.
   * 
   * 
   */


  listen(server_sock,5);

  /**
   *  
   * 할당 받은 서버가 수신을 대기할 대기열이다.
   * 현재 5명으로 설정되어 있고 , 인자 값으로
   * 첫번째는 서버의 디스크립터 정보, 두번째는 대기열 사이즈를 넘겨준다.
   * 
   */

  client_size = sizeof(struct sockaddr); // 메모리 할당전 sockaddr 사이즈 만큼 공간을 변수에 할당한다.
  client_sock = accept(server_sock,(struct sockaddr *)&client_addr,&client_size); // accpet를 시도하고 소켓 디스크립터 정보를 변수에 저장한다.

  /**
   * 
   *  accept() ? 
   *
   *  연결 받은 클라이언트 사이즈를 sockaddr 사이즈 만큼 할당하여 허용해준다.
   *  accept의 첫번째 인자는 서버의 디스크립터 정보를 넘겨주고
   *  두번째 인자 값은 연결 요청한 클라이언트의 주소 정보를 담은 주소 값을 전달한다.
   *  세번째 값은 할당할 사이즈를 넘겨준다.
   * 
   *  sockaddr를 사용하는 이유는 sockaddr_in은 accept시에 허용하지 않아 sockaddr로 형변환하여
   *  넘겨줘야한다.
   * 
   */
  
  
  if( client_sock != -1){
    printf("연결 성공!\n");
  }

  /**
   *
   * accept() 함수는 
   * 연결이 실패할경우 -1을 리턴하기 때문에
   * 연결이 성공할 경우 연결 성공 메시지를 출력해준다.
   * 
   */



/**
 * 주의! 
 * 
 * 서버는 항상 클라이언트의 요청을 먼저 받고 후에 응답하는 형식으로 제작하였습니다.
 * 당연한 이야기지만 서버에서 클라이언트쪽으로 먼저 연락을 보내면 클라이언트 차후 입력에서 같이 출력 됩니다.
 * 
 */


while(1)
  {


    

    recv(client_sock, in_buf, sizeof(in_buf), 0);
    printf("Received: '%s' \n", in_buf);

    gets(out_buf);
    send(client_sock, out_buf, (strlen(out_buf) + 1), 0);


    /**
     * 각 recv와 send는 데이터를 받고, 전송하는 역할을 수행한다. 
     * 
     * 제일 먼저, recv는 상대에게 데이터를 받아와 버퍼에 집어넣는 역할을 한다.
     * recv()의 첫번째 인자는 수신할 연결상태를 담은 소켓 , 두번째 인자는 데이터를 담을 버퍼의 포인터
     * 세번째 인자는 버퍼의 사이즈, 네번째 인자는 추가 옵션으로 필요 없을경우 0을 넣는다.
     * 
     * send()는 데이터를 입력한 값으로부터 받아 상대쪽에 전송하는 함수이다.
     * 첫번째 인자는 데이터를 보낼 대상의 연결 상태 소켓과 두번째 값은 전송할 버퍼의 포인터, 3번째 인자는 버퍼의사이즈
     * 네번째 인자는 추가 옵션이고 recv와 같이 필요 없을경우 0을 넣는다.
     * 
     * +1이 들어간 이유는 엔터를 하면 '\0' 과 같이 버퍼에 줄바꿈이 함께 들어오기 때문이다.
     * 
     */

    if (strcmp(out_buf, "quit") == 0){
      break;
    }

    /**
     * strcmp를 활용하여 quit를 입력하면 
     * while문을 탈춣할 수 있게 구성했다
     */

    
  }

#ifdef WIN
  closesocket(client_sock);
  closesocket(server_sock);
#endif
#ifdef BSD
  close(client_sock);
  close(server_sock);
#endif

#ifdef WIN
  WSACleanup();
#endif
  
  /**
   * close()? 
   * 
   * 각 통신이 끝난 소켓들을 닫아준다.
   * while문 안에서 작동하는 소켓들이 특정 입력으로 접속이 종료되면
   * close를 사용하여 사용한 소켓을 처리해준다.
   * 
   */
  

}
