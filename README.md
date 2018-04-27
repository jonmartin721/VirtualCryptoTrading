# Virtual Crypto Wallet and Trading 

This Java application shows how to create a Wallet object used to trade cryptocurrencies and store holdings. It is created for a class project, but can later be adapted to have more features. 

The goal of this application is to make hesitant traders more willing to try trading cryptocurrencies by not adding the pressure of using real money. All other values and operations are real however. We do this by freely allowing for the withdrawal and deposit of USD, but without having any effect.

### Instructions

For this application, you should run EchoServer before running EchoClient. Just type in 'localhost' if you're using the same machine, or you can type in the IP address if you know it (see picture 1).  After you set-up your login information and username, you will see a selection menu (see picture 2).  From this menu, you can navigate to different parts of the program like viewing how much is in your wallet, adding to your wallet, browsing current cryptocurrencies and trades.  You can even establish some financial goals you'd like to set for your portfolio.  You can move money into your wallet via the 'Deposit USD' option, and also withdraw from your wallet.  Changing or updating your password is an integral part of any proper application, and even though we did not implement encryption, the basic functionality of authentication is available via serialization of the files.  Obviously if this was published application, encryption would have to be implemented.  

There is also a help feature that explains all the menu options in detail.  And finally the save and exit options when the user is done with the program.  The final feature displays the user's exit balance in USD along with the value of total holdings.  Many safeguards have been implemented to catch any exceptions that might be thrown so the program with run relatively error-free.

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
CryptoCompare is an API that brings all the latest streamed pricing data in the world of cryptocurrencies. All the latest trades like Bitcoin, Ethereum, BTC Cash, Ripple and Litcoin to name a few.  The current rates for these crytocurrencies can be updated while program is running by selecting the "r" button that reloads the query in that area of the application (see picture 3).


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
This is the initial client/server connection (picture 1):

![ClientServer](http://u.cubeupload.com/texasrock/LoginScreen.jpg)


We use a menu, like the one shown below (picture 2):

![Interface](http://u.cubeupload.com/texasrock/Menu.jpg)


See the live API data in action (picture 3):

![API Data](https://u.cubeupload.com/texasrock/BrowseCryptos.jpg)


More detailed information or cryptocurrency within last 24 hours with a choice of options (picture 4):

![DetailedData](https://u.cubeupload.com/texasrock/DetaileData.jpg)


Example of what a proposed trade looks like (picture 5):

![ProposedTrade](https://u.cubeupload.com/texasrock/ProposedTrade.jpg)


