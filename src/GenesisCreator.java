import java.io.FileOutputStream;
import java.security.MessageDigest;

/**
 * Created by lschubert on 11/15/15.
 */
public class GenesisCreator {
    public static void main(String[] args)throws Exception{
        String blockStringView = "b:n:0:nd::dn:";
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        String firstHash = new String(digest.digest("0".getBytes()));
        blockStringView = blockStringView + firstHash +":n:b";

        FileOutputStream fos = new FileOutputStream("genesisBlock.b");
        fos.write(blockStringView.getBytes());
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
