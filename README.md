# Virtual Crypto Wallet and Trading 

This Java application shows how to create a Wallet object used to trade cryptocurrencies and store holdings. It is created for a class project, but can later be adapted to have more features. 

The goal of this application is to make hesitant traders more willing to try trading cryptocurrencies by not adding the pressure of using real money. All other values and operations are real however. We do this by freely allowing for the withdrawal and deposit of USD, but without having any effect.

### Instructions

For this application, you should run EchoServer before running EchoClient. Just type in 'localhost' if you're using the same machine, or you can type in the IP address if you know it.

### Features

This is a list of final features. They may not be fully implemented yet, but are feasible and will be added by the completion of the project.

- Secure login info storage and wallet storage
- Trade Bitcoin, Ethereum, Litecoin, Bitcoin Cash, Ripple, Dash, Monero, Neo, EOS, Cardano, Stellar
- Live data from the CryptoCompare API
- File operations
- Client/Server architecture
- Full BigDecimal for currency support


Less impressive but still important OOP features:
- Modular design
- Clearly commented code
- Clean interface
- Inheritance
- Abstraction
- Exception handling
- Serialization
- Networking

### API
CryptoCompare is an API that brings all the latest streamed pricing data in the world of cryptocurrencies. All the latest trades like Bitcoin, Ethereum, BTC Cash, Ripple and Litcoin to name a few.  The current trades for these crytocurrencies are streamed live and can be updated whilst program is running by selecting the "r" button the reloading the query.


### New to Crypto?
Cryptocurrencies are digital currencies that have some features that set them apart from their real-world counterparts. They are traded online and are much more volatile in value compared to traditional exchanges. Some of their features are:

- Anonymous (mostly)
- Quickly exchanged without physical interaction
- Built on new bleeding-edge platforms
- Can represent and be traded for smart contracts, electricity, computing power, or anything else agreed upon.

### Tips

When using this application, don't terminate execution prematurely. Save and exit at the main menu (option 0). This prevents files from being corrupted.

If you modify the Wallet class or any of its subclasses, all wallet files (***_wallet.ser) will not be usable anymore. This is because the UID of the wallet serialized and Wallet class do not match. All serialized files **must be manually deleted** if this happens. 

### Interface
This is the initial client/server connection

![ClientServer](http://u.cubeupload.com/texasrock/LoginScreen.jpg)

We use a menu, like the one shown below:

![Interface](http://u.cubeupload.com/texasrock/Menu.jpg)

See the live API data in action:

![API Data](https://u.cubeupload.com/texasrock/BrowseCryptos.jpg)

More detailed information or cryptocurrency within last 24 hours with a choice of options

![DetailedData](https://u.cubeupload.com/texasrock/DetaileData.jpg)

Example of what a proposed trade looks like

![ProposedTrade](https://u.cubeupload.com/texasrock/ProposedTrade.jpg)


