
// Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Marvolo {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();

        int n = sc.nextInt();
        long p = sc.nextLong();
        long q = sc.nextLong();
        long r = sc.nextLong();

        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long[] leftMax = new long[n];
        long maxSoFar = Long.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(maxSoFar < arr[i] * p) {
                maxSoFar = arr[i] * p;
            }

            leftMax[i] = maxSoFar;
            //System.out.println(leftMax[i]);
        }
        System.out.println();
        maxSoFar = Long.MIN_VALUE;
        long[] rightMax = new long[n];
        for(int i = n - 1; i >= 0; i--) {
            if(maxSoFar < arr[i] * r) {
                maxSoFar = arr[i] * r;
            }

            rightMax[i] = maxSoFar;
            //System.out.println(rightMax[i]);
        }
        
        maxSoFar = Long.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            long exp = leftMax[i] + (q * arr[i]) + rightMax[i];
            maxSoFar = Math.max(exp, maxSoFar);
        }

        System.out.println(maxSoFar);
    }    
}