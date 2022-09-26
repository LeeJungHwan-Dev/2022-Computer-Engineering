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
  #include <sys/types.h>    // Needed for system defined identifiers.
  #include <netinet/in.h>   // Needed for internet address structure.
  #include <sys/socket.h>   // Needed for socket(), bind(), etc...
  #include <arpa/inet.h>    // Needed for inet_ntoa()
  #include <fcntl.h>
  #include <netdb.h>
  #include <unistd.h> // 오류 해결을 위해 추가함
#endif

//----- Defines ---------------------------------------------------------------
#define  PORT_NUM         1050     // Port number used at the server
#define  IP_ADDR "127.0.0.1"       // IP address of server (*** HARDWIRED ***)

//===== Main program ==========================================================

unsigned int server_sock;
unsigned int client_sock;
struct sockaddr_in serverfd; // 소켓 도메인
struct sockaddr_in clientfd; // 소켓 도메인
socklen_t client_size;
char                 out_buf[4096]; // 100-byte output buffer for data
char                 in_buf[4096];






int main(void) // 에러 코드나와서 void main에서 int main으로 수정함
{


  server_sock = serverfd.sin_family = AF_INET;
  serverfd.sin_addr.s_addr = inet_addr(IP_ADDR);
  serverfd.sin_port = htons(PORT_NUM);



  server_sock = socket(AF_INET,SOCK_STREAM,0);
  bind(server_sock,(struct sockaddr *)&serverfd, sizeof(serverfd));
  bzero(&serverfd,sizeof(serverfd));
  listen(server_sock,5);

  client_size = sizeof(struct sockaddr);
  client_sock = accept(server_sock,(struct sockaddr *)&clientfd,&client_size);
  
  
  if( client_sock != -1){
    printf("연결 성공!\n");
  }



while(1)
  {
    // >>> Step #3 <<<
    // Send to the server
    // Type the message 
    //gets(out_buf);

    //gets(out_buf);

    // Bail out if "quit" is entered
    if (strcmp(out_buf, "quit") == 0){
      break;
    }



    //send(client_sock, out_buf, (strlen(out_buf) + 1), 0);


    recv(client_sock, in_buf, sizeof(in_buf), 0);
    printf("Received: '%s' \n", in_buf);

  

    

    // >>> Step #4 <<<
    // Receive from the server 
    
  }



  close(client_sock);
  close(server_sock);
  
  
  





}
