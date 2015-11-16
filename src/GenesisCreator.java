import java.io.FileOutputStream;

/**
 * Created by lschubert on 11/15/15.
 */
public class GenesisCreator {
    public static void main(String[] args)throws Exception{
        byte[] genBlockByteView = {0x4A, 0x5B};

        FileOutputStream fos = new FileOutputStream("genesisBlock.b");
        fos.write(genBlockByteView);
        fos.close();

    }

    public static void printHex(byte[] ba) {
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<ba.length;i++) {
            String hex=Integer.toHexString(0xff & ba[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString.toString());
    }
}
