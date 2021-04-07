# My Personal Project - Meme Stock Portfolio

## :rainbow: :bear:

My application will allow users to create a portfolio consisting of meme stocks, in the style of Reddit's 
*r/wallstreetbets* community. Users will be able to pick stocks from a pre-defined list, or add their own stonks to YOLO.

Users will be able to run a simulation of how their stocks perform 
over time. Will their :gem: :raised_hands: diamond hands :raised_hands: :gem: pay off as their stock goes :rocket: 
:rocket: to the moon :first_quarter_moon_with_face: :full_moon_with_face:, or will they lose it all and prove the 
:rainbow: :bear: bears right??

Users will be people interested in everything *r/wallstreetbets*. Alternatively, :triumph: **activists** :triumph: who 
are interested in sticking it to Wall Street are also welcome to use the application. 

NB: if you are an experienced investor looking for an intelligent way to understand your portfolio and risk profile, 
please head elsewhere. Only degenerate "investors" welcome.

## :gem: :raised_hands: :rainbow: :bear: :rocket: :rocket: :rocket: :first_quarter_moon_with_face: 
## :first_quarter_moon_with_face: User stories

User stories (Phase 1):
- As a user, I want to be able to choose meme stonks to YOLO (add to my portfolio)
- As a user, I want to be able to create my own stock (ticker) to add to my portfolio
- As a user, I want to see how my portfolio has done over a period of time
- As a user, I want to decide whether to sell or :rocket: :rocket: HOLD THE LINE 
  :rocket: :rocket: against my wife's boyfriend's advice
  
User stories (Phase 2):
- As a user, I want to be able to save my Portfolio to file 
- As a user, I want to be able to load my Portfolio from a file

Phase 4: Task 2
I chose to implement the BoringStock and MemeStock subclasses, as subtypes of the Stock interface. Each of BoringStock 
and MemeStock override the changeValueOverTime method, providing distinct implementations of the method. 

Phase 4: Task 3
Based on the UML class diagram, what's starkly apparent is that the current design of my program exhbits a 
**significant** degree of coupling; primarily involving the classes required for the GUI and the Portfolio class. 
In order to remediate this, I would use the Java Observer pattern, and replace most/all of the Portfolio fields 
(indirectly) by adding the class to the list of Observers for Portfolio (which will extend the Observer class). I will
call notifyObservers() every time something salient happens to the Portfolio (e.g. added a Stock, changed value over
time), and the update() methods of the Observers would be implemented according to the specific aims of each class.



