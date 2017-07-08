pragma solidity ^0.4.0;

contract CheckEthereumAddress {
  
   /*Ref: http://solidity.readthedocs.io/en/develop/assembly.html
     EXTCODESIZE is the EVM opcode for getting the size of the code at an address.
     so we use the function which will fetch the size of code of a address
     if it is simple account then the code size is 0
   */
   
   /*
   For testing publish the contract in Remix browser and copy the address
   then tested it
   Contract Address: "0x692a70d2e424a56d2c6c27aa97d1a86395877b3a"
   Also tested with normal Address
   Normal Address: "0x0a99e4c3ecdfcaeb5281cfe8d81cbdefa93ff555"
   */
   
   event print_a(address a);
   function checkAddressType(address addr) returns (string) {
      print_a(addr); 
      uint size;
      assembly { size := extcodesize(addr) }
      if(size > 0)
      {
         return "Valid Ethereum Contract Address";  
      }
      
      return "Valid Ethereum Simple Account Address";
      
      }
      
}