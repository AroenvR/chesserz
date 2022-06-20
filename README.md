# chesserz
The best chess application for the busy person. Keep on fightin', tiger!

---

This project is probably closed.  
The purpose of this project was for me to have a clear indication of how I wanted to tackle the Chesserz's Solidity SmartContract.  
That contract is currently functional on MetisDAO's TestNet at: 0x1EE196BC220ac2F7Af99475d1FD0F3b6614c8CF1  
ABI at the bottom of this file.

The frontend for the application (WIP) is at: https://github.com/AroenvR/chesserz-frontend  
On the Heroku page: https://chesserz.herokuapp.com/chesserz-frontend/game/0x8012D8cA704c26D708546C4153715C8a8E939D44/0x6d485C5669Ff9056C12d50052077CfD95b93F0ac  
(2 wallet addresses are necessary to view a specific game. These are 2 of my public 'throwaway' addresses.)

-> If the frontend looks broken, make sure you're on the Metis Stardust Testnet.

---

FenService SmartContract ABI:  
"abi": [
    {
      "inputs": [
        {
          "internalType": "address",
          "name": "address_white",
          "type": "address"
        },
        {
          "internalType": "address",
          "name": "address_black",
          "type": "address"
        }
      ],
      "name": "createBoard",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "address",
          "name": "address_white",
          "type": "address"
        },
        {
          "internalType": "address",
          "name": "address_black",
          "type": "address"
        }
      ],
      "name": "findBoardByAddresses",
      "outputs": [
        {
          "internalType": "contract FenBoard",
          "name": "fenBoard",
          "type": "address"
        }
      ],
      "stateMutability": "view",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "address",
          "name": "address_white",
          "type": "address"
        },
        {
          "internalType": "address",
          "name": "address_black",
          "type": "address"
        }
      ],
      "name": "getBoardState",
      "outputs": [
        {
          "internalType": "string",
          "name": "",
          "type": "string"
        }
      ],
      "stateMutability": "view",
      "type": "function"
    },
    {
      "inputs": [],
      "name": "getGreeting",
      "outputs": [
        {
          "internalType": "string",
          "name": "",
          "type": "string"
        }
      ],
      "stateMutability": "pure",
      "type": "function"
    },
    {
      "inputs": [
        {
          "internalType": "string",
          "name": "boardState",
          "type": "string"
        },
        {
          "internalType": "address",
          "name": "address_white",
          "type": "address"
        },
        {
          "internalType": "address",
          "name": "address_black",
          "type": "address"
        }
      ],
      "name": "updateBoard",
      "outputs": [],
      "stateMutability": "nonpayable",
      "type": "function"
    }
  ]
