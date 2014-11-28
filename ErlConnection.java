import com.ericsson.otp.erlang.OtpConnection;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpPeer;
import com.ericsson.otp.erlang.OtpSelf;
import com.ericsson.otp.erlang.OtpNode;
import com.ericsson.otp.erlang.OtpMbox;
 
 
public class ErlConnection {
 
     private static OtpConnection conn;
     public OtpErlangObject received;
     private final String peer;
     private final String cookie;
      
     // public static void main(String []args){
     //     new ErlConnection("enode","erlang");
     // }
 
      public ErlConnection(String _peer, String _cookie) {
          //peer = _peer;
      	  peer = "evan@ubuntu";
          cookie = _cookie;
          connect();
 
           /*Do Calls to Rpc methods and then close the connection*/
          //disconnect();
 
      }
 
      public void connect() {
       System.out.print("Please wait, connecting to "+peer+"....\n");
 
       String javaClient ="java";
       try {
         OtpSelf self = new OtpSelf(javaClient, cookie.trim());
         OtpPeer other = new OtpPeer(peer.trim());
         conn = self.connect(other);

         // OtpSelf client = new OtpSelf("client", "cookie");
         // OtpPeer server = new OtpPeer("erlang@Dixons-MacBook-Air");
         // conn = client.connect(server);

         System.out.println("Connection Established with "+peer+"\n");
       }
       catch (Exception exp) {
         System.out.println("connection error is :" + exp.toString());
         exp.printStackTrace();
       }
 
     }

     // public void connect(){
     // 	OtpNode self = null;
     //    OtpMbox mbox = null;
     //    try {
     //        self = new OtpNode("client", cookie);
     //        mbox = self.createMbox("facserver");
 
     //        if (self.ping(peer, 2000)) {
     //            System.out.println("remote is up");
     //        } else {
     //            System.out.println("remote is not up");
     //            return;
     //        }
     //    } catch ( Exception e1) {
     //    	System.out.println("connection error is :" + e1.toString());
     //        e1.printStackTrace();
     //    }
     // }
 
     public void disconnect() {
       System.out.println("Disconnecting....");
       if(conn != null){
         conn.close();
       }
       System.out.println("Successfuly Disconnected");
     }
 
}
