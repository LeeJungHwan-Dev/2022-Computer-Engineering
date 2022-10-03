/**
 * @file server.c
 * @author 이정환 (leeejh@jbnu.ac.kr) / 201812163
 * @brief 
 * @version 0.1
 * @date 2022-10-03
 * 
 * @copyright Copyright (c) 2022
 * 
 */


//=================================================== file = echoclient.c =====
//=  A simple echo client to demonstrate sockets programming                  =
//=   - TCP/IP client/server model is implemented                             =
//=============================================================================
//=  Notes:                                                                   =
//=    1) This program conditionally compiles for Winsock and BSD sockets.    =
//=       Set the initial #define to WIN or BSD as appropriate.               =
//=    2) There is *no* error checking in this program.  Error checking was   =
//=       omitted to simplify the program.                                    =
//=    3) This program needs server to be running on another host.  Program   =
//=       server should be started first.                                     =
//=    4) This program assumes that the server has the IP address hardcoded   =
//=       into "#define IP_ADDR"                                              =
//=---------------------------------------------------------------------------=
//=  Build: bcc32 echoclient.c or cl echoclient.c wsock32.lib for Winsock     =
//=         gcc echoclient.c -lsocket -lnsl for BSD                           =
//=---------------------------------------------------------------------------=
//=  History:  ZG (08/06/01) - Genesis - from client.c by KJC                 =
//=                                                                           =
//=============================================================================
#define  BSD                // WIN for Winsock and BSD for BSD sockets

//----- Include files ---------------------------------------------------------
#include <stdio.h>          // Needed for printf()
#include <string.h>         // Needed for memcpy() and strcpy()

#ifdef WIN
  #include <windows.h>      // Needed for all Winsock stuff
#endif
#ifdef BSD
  #include <sys/types.h>    // socket bind를 위한 헤더 파일
  #include <netinet/in.h>   
  #include <sys/socket.h>   // socket bind를 위한 헤더 파일
  #include <arpa/inet.h>    // arpa또는 inet.h 하나만 넣어줘도 된다. 이는 2개를 전부 선택한거다.
  #include <fcntl.h>
  #include <netdb.h>
  #include <unistd.h> // 오류 해결을 위해 추가함
#endif

//----- Defines ---------------------------------------------------------------
#define  PORT_NUM         1050 // 서버 연결에 사용할 포트
#define  IP_ADDR "127.0.0.1"  // 서버 연결에 사용할 IP

//===== Main program ==========================================================
int main(void) // 에러 코드나와서 void main에서 int main으로 수정함
{


#ifdef WIN
  WORD wVersionRequested = MAKEWORD(1,1);       // Stuff for WSA functions
  WSADATA wsaData;                              // Stuff for WSA functions
#endif

  unsigned int         server_s;        // 서버 소켓 상태를 저장하기 위한 변수 (디스크립터)
  struct sockaddr_in   server_addr;     // 서버 소켓의 주소를 담을 server_addr 변수 // AF_INET을 사용하기 때문
  char                 out_buf[100];    // 전송할 데이터를 담을 버퍼
  char                 in_buf[100];     // 받을 데이터를 담을 버퍼

#ifdef WIN
  WSAStartup(wVersionRequested, &wsaData);
#endif


  server_s = socket(AF_INET, SOCK_STREAM, 0);

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


  server_addr.sin_family      = AF_INET;            //sin_family는 주소체계를 저장하는 필드이다.
  server_addr.sin_port        = htons(PORT_NUM);    //sin_port는 포트 정보를 저장하는 값 입니다.
  server_addr.sin_addr.s_addr = inet_addr(IP_ADDR); //s_addr는 ip주소를 저장하는 구조체이다.

  connect(server_s, (struct sockaddr *)&server_addr, sizeof(server_addr));



  /**
   *  
   * connect() ?
   * connect 함수는 일종의 서버에게 연결 요청을 하는 함수이다.
   * 첫번째 인자로 할당 받은 소켓의 디스크립터를 넘겨주고, 
   * 두번째로 sockaddr 즉, 연결할 서버 정보가 담긴 server_addr의 값을 넘겨준다. 
   * 마지막으로 serveraddr에 전달된 주소 변수 크기를 바이트 단위로 전달한다.
   * 
   */

  /**
   * 클라이언트에서는 
   * connect()를 호출하면 자동적으로 ip와 포트가 할당되기 때문에
   * bind를 진행할 필요가 없다.
   * 
   */



    
      while(1)
      {

        gets(out_buf);
        send(server_s, out_buf, (strlen(out_buf) + 1), 0);

        if (strcmp(out_buf, "quit") == 0){
            break;
        }

        recv(server_s, in_buf, sizeof(in_buf), 0);
        printf("Received: '%s' \n", in_buf);
        

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


        
      }

  
#ifdef WIN
  closesocket(server_s);
#endif
#ifdef BSD
  close(server_s);
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
