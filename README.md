# Virtual Crypto Wallet and Trading 

This Java application shows how to create a Wallet object used to trade cryptocurrencies and store holdings. It is created for a class project, but can later be adapted to have more features. 

The goal of this application is to make hesitant traders more willing to try trading cryptocurrencies by not adding the pressure of using real money. All other values and operations are real however. We do this by freely allowing for the withdrawal and deposit of USD, but without having any effect.

### Instructions

For this application, you should run EchoServer before running EchoClient. Just type in localhost if you're using the same machine, or you can type in the IP address if you know it.

### Features

This is a list of final features. They may not be fully implemented yet, but are feasible and will be added by the completion of the project.

- Secure login info storage and wallet storage
- Trade Bitcoin, Ethereum, Litecoin, and Bitcoin Cash
- Live data from the Coinbase exchange API
- File operations
- Client/Server architecture


Less impressive but still important OOP features:
- Modular design
- Clearly commented code
- Clean interface
- Inheritance
- Abstraction
- Exception handling
- Serialization
- Networking

### Libraries
The only library currently used is [XChange](https://github.com/knowm/XChange). It is a Java library that can connect with many exchanges to pull data and perform real trades on a wallet.

### New to Crypto?
Cryptocurrencies are digital currencies that have some features that set them apart from their real-world counterparts. They are traded online and are much more volatile in value compared to traditional exchanges. Some of their features are:

- Anonymous (mostly)
- Quickly exchanged without physical interaction
- Built on new bleeding-edge platforms
- Can represent and be traded for smart contracts, electricity, computing power, or anything else agreed upon.

### Tips

When using this application, don't terminate execution prematurely. Save and exit at the main menu (option 0). This prevents files from being corrupted.

You can use Maven to import by adding the Maven coordinates that can be found at the XChange link above in the libraries section.

If you modify the Wallet class or any of its subclasses, all wallet files (xyz_wallet.ser) will not be usable anymore. This is because the UID of the wallet serialized and Wallet class do not match. All serialized files **must be deleted** if this happens. 

### Interface

We use a menu, like the one shown below:

![Interface](http://i.cubeupload.com/bi0Aho.png)

See the live API data in action:

![API Data](http://i.cubeupload.com/wfJVwn.png)
