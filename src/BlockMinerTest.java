import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by lschubert on 11/16/15.
 *
 * this will take an array from a block interpreter and find a new hash value to match for the next block.
 */
public class BlockMinerTest {
    final int ZEROS = 2;
    private byte[] newMatch;
    private byte[] result;

    public BlockMinerTest(byte[] b) throws Exception{
        boolean matchFound = false;
        //static size for test bytes might have unwanted side effect. rethink this.
        byte[] testBytes = new byte[64];
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        Random r = new Random();

        while(!matchFound){
            byte[] testHash = new byte[128];
            //create random bytes.
            r.nextBytes(testBytes);

            //concatenate prev with new bytes.
            System.arraycopy(b,0,testHash,0,64);
            System.arraycopy(testBytes,0,testHash,64,64);

            byte[] newHash = digest.digest(testHash);
            System.out.println(Arrays.toString(newHash));
            //check if first 4 bytes are 0. if yes found
            boolean correctZero = true;
            for(int i =0; i<ZEROS;i++){
                if(newHash[i] != 0){
                    correctZero = false;
                }
            }
            if(correctZero){
                newMatch = testBytes;
                result =newHash;
                matchFound = true;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
