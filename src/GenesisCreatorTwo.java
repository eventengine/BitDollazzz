import com.sun.tools.javac.util.ArrayUtils;

import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * Created by lschubert on 11/16/15.
 */
public class GenesisCreatorTwo {
    public static void main(String[] args) throws Exception{
        //first block will only contain 128 bytes of data.
        //hash of 0 as previous block value since it is first block.
        //randomly generated number for second hash.
        byte[] firstBlockBytes = new byte[128];
        MessageDigest digest = MessageDigest.getInstance("SHA-512");

        //create two random hashes. the second one will be used to calculate the next hash.
        byte[] firstHalf = digest.digest(randomBytes());
        byte[] secondHalf = digest.digest(randomBytes());
        System.arraycopy(firstHalf,0,firstBlockBytes,0,64);
        System.arraycopy(secondHalf,0,firstBlockBytes,64,64);
        System.out.println(Arrays.toString(firstBlockBytes));

        //name of block file is >> genBlock <<
        FileOutputStream fOS = new FileOutputStream("genBlock");
        //encode the block to b64 and write to file.
        fOS.write(encodeToB64(firstBlockBytes));

    }

    private static byte[] encodeToB64(byte[] b){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encode(b);
    }

    private static byte[] randomBytes(){
        byte[] output = new byte[64];
        Random r = new Random();
        r.nextBytes(output);

        return output;
    }


}
