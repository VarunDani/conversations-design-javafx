Conversations Design (JavaFX)
-----------------------------

**Description:** 

This design is made for Conversation.im Project (Teaser task). 

**/ChatClientDemo :** The Folder contain Eclipse Project and static design layout developed with help of materialized design principles and related to conversation layout.

**/ExecutableJAR:**  This folder contains executable JAR file and supported resource file. (Execution instructions are mentioned in below steps)





**How to Run :**

For Windows User :

 1. Fork repository or Download repository as zip. 
 2. Browse to Folder /ExecutableJAR and run command (jdk : 1.8.121 ): 

> java -cp conversations-design-javafx.jar;lib/*;. im.conversations.app.launch.MainDemo





**Screen layout :**


**1. Main Chat Window Screen**

Main chat window includes left user panel, right panel for selection and center panel for chat messages. All components are developned in materialized template and flow according to main screen layout.

![](/SupportedFiles/mainScreen.jpg?raw=true)


**2. User Selection (left panel)**

User can be selected from left chat panel. Ripple color can be customized for user or group.
Status circle (online, Away, Busy) is independent component from screen and can be customized dynamically at run time.

![](/SupportedFiles/userSelection.gif?raw=true)


**3. Channel or Group Selection right menu**

Channels or Individual person selection can also be perform with click of right menu
Avatar Image and shadow of image are dynamic components and can be configured run time. Also Icons in channel and user selection window can be bind dynamically.

![](/SupportedFiles/rightPanel.gif?raw=true)


**4. Options pop-up menu**


![](/SupportedFiles/popUpMenu.gif?raw=true)


**5. Materialized Message Box Layout at bottom of Chat Window**

Materialize Text Support provided to Text Field for Entering Chat.

![](/SupportedFiles/textBoxSelection.gif?raw=true)


**6. Can initiate New Message after Entering Text and pressing Enter Key.**

For prototype Added Emoji Support at time of message and it will be extended by clicking left emoji button 
Three formats supported for current implementation

~smile~ : for Smiling 
~laugh~ : for Laughing
~heart~ : for heart

![](/SupportedFiles/emojiSupport.gif?raw=true)


**Contribution : **
If you like creation of design and want to implement in your project: Instead of copying please contact me I would love to contribute open source community. 

Varun Dani
dani.varun.36@gmail.com


References : 
https://developers.google.com/open-source/gsoc/
https://developers.google.com/open-source/gsoc/resources/media
https://summerofcode.withgoogle.com/organizations/5092439766335488/
http://www.jfoenix.com/index.html
https://www.billmann.de/2013/07/03/javafx-custom-listcell/
https://bitbucket.org/sco0ter/babbler/
http://emojipedia.org/
http://emojione.com/