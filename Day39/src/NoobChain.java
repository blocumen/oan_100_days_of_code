import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class NoobChain {

    public static ArrayList<Block>  blockchain = new ArrayList<Block>();
    public static int difficulty = 0;
    public static void main(String[] args)
    {
        /* Block genesisBlock = new Block("This is the genesis block","0");
        System.out.println("Hash for the first block is "+genesisBlock.hash);

        Block secondBlock = new Block("This is the second block",genesisBlock.hash);
        System.out.println("Hash for the second block is "+secondBlock.hash);

        Block thirdBlock = new Block("This is the third block",secondBlock.hash);
        System.out.println("Hash for the third block is "+thirdBlock.hash);
       //512

         */
        blockchain.add(new Block("This is the genesis block","0"));
        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineBlock(difficulty);

       blockchain.add(new Block("This is the second block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("This is the third block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
    public static boolean isChainValid()
    {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        for(int i=1;i<blockchain.size();i++)
        {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if(!currentBlock.hash.equals(currentBlock.calculateHash()))
            {
                System.out.println("hashes are not equal");
                return  false;
            }
            if(!previousBlock.hash.equals(currentBlock.previousHash))
            {
                System.out.println("Previous hash is not equal");
                return false;
            }
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return  true;
    }

}

