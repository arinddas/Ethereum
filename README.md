# Ethereum
This repositary contains various codes related to Ethereum Blockchain	

Program 1:
Code to check a valid Ethereum Address.
Language: Java

Test Cases:

1. Normal Address Checking:

sysout:

Incoming Address 0x0a99e4c3ecdfcaeb5281cfe8d81cbdefa93ff555

Valid Ethereum Address



2. Checksum Address checking:

sysout:

Incoming Address 0x65601DB7431427E32Ce2d60e6a373bc7A7F68EB4

Fetched Original Address 65601db7431427e32ce2d60e6a373bc7a7f68eb4

Hex String 8a380c81a2c005ea9e272e743550342ef1e619e7101df0a772e233b3e834a588

Position Upper D

Position digest c

Position Upper B

Position digest 8

Position Upper E

Position digest e

Position Upper C

Position digest e

Position Upper A

Position digest f

Position Upper F

Position digest e

Position Upper E

Position digest 9

Position Upper B

Position digest e

Valid Checksummed Ethereum Address



3. Invalid Address:

sysout:

Incoming Address 0x0a99e4c3ecdfcaeb5281cfe8d81cbdefa93fG555

Not A Valid Ethereum Address



Program 2:

Check Ethereum Address is for simple Account of Contract Account:

Language : Solidity


Test Cases:

1. Contract Address:

Result:

"0x0000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000001f56616c696420457468657265756d20436f6e7472616374204164647265737300"

Transaction cost: 24470 gas. 

Execution cost: 1790 gas.

Decoded: 

    string: Valid Ethereum Contract Address
    
	
print_a[
  "0x692a70d2e424a56d2c6c27aa97d1a86395877b3a"
]	

2. Simple Account Address:

Result: 

"0x0000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000002556616c696420457468657265756d2053696d706c65204163636f756e742041646472657373000000000000000000000000000000000000000000000000000000"

Transaction cost: 24557 gas. 

Execution cost: 1877 gas.

Decoded: 

    string: Valid Ethereum Simple Account Address
    
print_a[
  "0xa99e4c3ecdfcaeb5281cfe8d81cbdefa93ff555"
]

