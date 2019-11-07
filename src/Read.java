import java.nio.CharBuffer;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        CharBuffer buf1=CharBuffer.allocate(1024);
        CharBuffer buf2=CharBuffer.allocate(1024);
        boolean isPut=true;
        while (isPut){
            char[] chars=putIn();
            buf1.put(chars);
            buf1.flip();
            while (buf1.hasRemaining()){
                char c=buf1.get();
                if(c=='#'){
                    char c1=buf1.get();
                    switch (c1){
                        case 'b':
                            buf2.position(buf2.position()-1);
                            break;
                        case 'c':
                            buf2.position(buf2.position()-buf1.position()+2);
                            break;
                        case 'o':
                            isPut=false;
                            buf2.position(buf2.position());
                            buf2.put('\n');
                            break;
                        default:
                            buf2.put('#');
                            buf1.position(buf1.position()-1);
                            break;
                    }
                }else {
                    buf2.put(c);
                }
            }
            buf1.clear();//清空接收下一行数据
            buf2.put('\n');//换行
        }

        //输出
        buf2.flip();
        while (buf2.hasRemaining()){
            char x=buf2.get();
            if(x=='\n'){
                System.out.println("");
            } else {
                System.out.print(x);
            }
        }
    }
    public static char[] putIn(){
        Scanner putIn=new Scanner(System.in);
        String put=putIn.nextLine();
        put.toCharArray();
        return put.toCharArray();
    }
}
