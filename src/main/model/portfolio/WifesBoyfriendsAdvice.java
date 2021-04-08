package model.portfolio;

import java.util.*;
import java.util.Random;

//Represents advice in the form of Strings for use in the console version of the MemePortfolioApp
public class WifesBoyfriendsAdvice {
    private static List<String> advice = new ArrayList<>();
    //Random randomGenerator = new Random();

    //REQUIRES: advice is empty
    //MODIFIES: advice (this.advice)
    //EFFECTS: add Strings of advice to advice list then returns a random String from the list
    public static String getAdvice() {
        collectAdvice1(advice);
        collectAdvice2(advice);
        collectAdvice3(advice);
        collectAdvice4(advice);
        collectAdvice5(advice);
        collectAdvice6(advice);
        collectAdvice7(advice);
        return advice.get(new Random().nextInt(advice.size()));
    }

    //REQUIRES: advice is empty
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice1(List<String> l) {
        //l.add("DIAMOND HANDS BABY  \uD83E \uDD32 \uD83D \uDE80 \uD83D \uDE80 \uD83D \uDE80 \uD83D \uDE80");
        l.add("DIAMOND HANDS BABY");
        //l.add("TO THE MOON!!! \uD83D\uDE80\uD83D\uDE80\uD83D\uDE80\uD83D\uDE80\n");
        l.add("TO THE MOON!!!!");
        l.add("ONE OF US!! ONE OF US!!");
        l.add("Those are rookie numbers -- you gotta get those numbers up");
        l.add("It's been an honour");
        l.add("Someone mod this guy");
        l.add("Am I doing this right?");
        l.add("Tendies");
        l.add("Sweet tendies");
        l.add("Easy money baby");
        l.add("Frozen goes in the microwave, tendies come out, you can't explain that");
        l.add("The best way to learn is to lose money then post your position "
                + "and people will tell you why you're stupid");
        l.add("It's hard to buy high and sell low when your options expire worthless...");
        l.add("TSLA wants to know your location");
        l.add("I love inside jokes. Someday I'd like to be a part of one.");
        l.add("'Investing'");
        l.add("Risk free");
        l.add("Literally can't lose");
        l.add("What could possibly go wrong?");
        l.add("Watch this");
        l.add("Gentlemen...");
        l.add("Hold my Molson");
    }

    //REQUIRES:
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice2(List<String> l) {
        l.add("It matters not what you do but what you do with what you've done for others.");
        l.add("If I’m not mistaken...you just tried to bribe a federal officer.");
        l.add("Well, when you sail on a boat fit for a Bond villain, sometimes you need to play the part, right?");
        l.add("Apes together strong");
        //l.add("HOLD THE LINE BOYS! GME TO THE MOON! \uD83D\uDE80\uD83D\uDE80\uD83D\uDE80\uD83D\uDE80\uD83D\uDE80");
        l.add("HOLD THE LINE BOYS! GME TO THE MOON!");
        l.add("Ape-like, sheep-like, lemming-like, herd-like");
        l.add("In Shakespeare's time, the word 'ape' meant both 'primate' and 'imitate'");
        l.add("GUHhhh");
        l.add("HOLD, THE SQUEEZE IS GONNA HAPPEN ANY DAY NOW, THIS IS GOING TO $10,000");
        l.add("(Sniffles) These hands are still made of diamonds, damnit.");
        l.add("Buy Dogecoin");
        l.add("Buy SLVR futures");
        l.add("Can I buy some $ROPE");
        //l.add("\uD83E\uDD11\uD83E\uDD11\uD83D\uDE4C\uD83D\uDE4C\uD83D\uDE80\uD83D\uDE80\uD83E\uDD11\uD83E\uDD11");
        l.add("THe SqUEEEEEzeeee");
        l.add("Just YOLO'd 700k");
        l.add("Just YOLO'd my student loans");
        l.add("Just YOLO'd my life savings");
        l.add("Just YOLO'd my wife's inheritance");
        l.add("Just YOLO'd my wife's boyfriends paycheck");
        l.add("Just YOLO'd my stimulus check");
        l.add("HE HOLDS WE HOLD");
    }

    //REQUIRES:
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice3(List<String> l) {
        l.add("I know how to invest - I've seen the Wolf of Wall Street");
        l.add("I know how to invest - I've seen the Margot Robbie scene in The Big Short. Wasn't paying attention tho");
        l.add("The Wolf of Wall Street is the best documentary I've ever seen");
        l.add("SHTEEEEEVE MADDDDDEN");
        l.add("What's a put?");
        l.add("What's a call?");
        l.add("Like 4chan found a Bloomberg Terminal");
        l.add("If you ain't leveraged, you ain't winning.");
        l.add("Leveraged to the gills");
        l.add("Alright, alright, alright");
        l.add("#FREESHKRELI");
        l.add("Can I trade stocks if I'm 12?");
        l.add("What's intrinsic value?");
        l.add("I think my iPhone's glitching - my Robinhood app can only display red");
        l.add("Why do I get literally zero matches on Grindr?");
        l.add("Box spreads babyyyyyyy");
        l.add("Stocks literally only ever go up. Lol. ");
        l.add("Always look on the bright side of life");
        l.add("If you can dream it you can do it");
        l.add("Mazel tov");
        l.add("You only live twice");
        l.add("Pick up the phone and start dialling");
        l.add("ABC: Always be closing");
    }

    //REQUIRES:
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice4(List<String> l) {
        l.add("Investing is like gambling. The House makes sure you win.");
        l.add("Let me tell you something. There's no nobility in poverty");
        l.add("Give them to me young, hungry, and stupid. And in no time, I will make them rich.");
        l.add("If my lawyer calls, tell him he's fired.");
        l.add("I'm never eating at Benihana again. I don't care whose birthday it is.");
        l.add("I want you to deal with your problems by becoming rich");
        l.add("Sell me this pen");
        l.add("Whatever you do -- don't die sober.");
        l.add("I would pay like $500k to watch the Kardashians play scrabble.");
        l.add("If I could choose between world peace and a reasonable fortune, my first Lambo would be orange.");
        l.add("When life gives you lemons, order the lobster tail.");
        l.add("If you can only teach your kids one thing: tell them Santa loves rich kids more");
        l.add("YOLO is poor for carpe diem.");
        l.add("Money might not buy happiness, but I'll take my chances");
        l.add("Handshakes and tie knots. I don't have time for someone who can't master those basic skills.");
        l.add("If you can only be good at one thing, be good at lying.  "
                + "Because if you're good at lying, you're good at everything.");
        l.add("The most and least successful people all share the same trait: thinking they’re never wrong.");
        l.add("Don’t worry, some people are their own punishment in life.");
    }

    //REQUIRES:
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice5(List<String> l) {
        l.add("Listening is part waiting for your turn to speak "
                + "and part reminding yourself to change facial expressions every 10 seconds.");
        l.add("Before people are allowed to opine about Syria, they should have to locate it on a map.");
        l.add("Let’s be honest. There’s no way your guess is as good as mine.");
        l.add("sometimes, people who don’t say much don’t say much for a reason.");
        l.add("I never said I was better than anyone, just more successful.");
        l.add("Do 50 push-ups, sit-ups, and dips before you shower each morning.");
        l.add("Some of the best moments in life are the ones you can’t tell anyone about.");
        l.add("Start every phone call with “my phone’s about to die” so they don’t waste your time.");
        l.add("If life’s a game, money is how you keep score.");
        l.add("People who always fly business class don’t post photos of themselves flying business class.");
        l.add("Flowers and an apology are a lot easier than actually changing.");
        l.add("You can never awaken a man who is pretending to be asleep.");
        l.add("If you abstain from smoking, drinking, and using drugs, you don’t actually live longer. "
                + "It just seems longer.");
        l.add("Don’t confuse friends, work friends, and friends of convenience");
        l.add("Work hard. Eat right. Exercise. Don’t drink too much. And only buy what you can afford. "
                + "It’s not rocket science.");
    }

    //REQUIRES:
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice6(List<String> l) {
        l.add("“Just be yourself” is good advice to probably 5% of people.");
        l.add("Never join a Zoom call without your trousers on.");
        l.add("How Can Mirrors Be Real If Our Eyes Aren't Real?");
        l.add("Pro tip: You're gonna be okay");
        l.add("Today isn't the worst day of your life. It's the worst day of your life so far.");
        l.add("Most people wouldn’t even be the main character in a movie about their own lives.");
        l.add("Don't be contrarian. Contrarianism is dogmatic in its own way. Be anti-mimetic.");
        l.add("You can only find secrets if you believe that they exist");
        l.add("Talent is the only thing that stands between most people and their dreams.");
        l.add("Brilliant thinking is rare, but courage is in even shorter supply than genius");
        l.add("Every moment in business happens only once.");
        l.add("Music was better when ugly people were allowed to make it.");
        l.add("Tattoos aren’t my thing. That’d be like putting a bumper sticker on a Lamborghini.");
        l.add("You ever try DMT?");
        l.add("AI is like religion for atheistic nerds. Nobody likes a Cassandra.");
        l.add("If someone has a tattoo saying, ‘Only God Can Judge Me’, prove them wrong.");
        l.add("The most entertaining outcome is the most likely. The creator of the Simulation has a sense of humour");
        l.add("I want to talk to God but I'm afraid because we ain't spoke in so long.");
    }

    //REQUIRES:
    //MODIFIES: advice (this.advice)
    //EFFECTS: adds Strings of advice to advice list
    public static void collectAdvice7(List<String> l) {
        l.add("You’re not perfect but you’re not your mistakes");
        l.add("Breathe");
        l.add("Meditate");
        l.add("Hydrate");
        l.add("Madness is rare in individuals—but in groups, parties, nations, and ages it is the rule");
        l.add("Shallow men believe in luck, believe in circumstances… Strong men believe in cause and effect.");
        l.add("Victory awaits he who has everything in order. Luck, people call it.");
        l.add("The harder I work, the luckier I get.");
        l.add("The best projects are likely to be overlooked, not trumpeted by a crowd; "
                + "the best problems to work on are often the ones nobody else even tries to solve.");
        l.add("Only invest in companies that have the potential to return the value of the entire fund.");
        l.add("Sometimes you do have to fight. Where that’s true, you should fight and win.");
        l.add("Success is never accidental");
        l.add("Living Is Easy With Eyes Closed.");
        l.add("Greed is good.");
        l.add("Why do you hold it in?");
        l.add("Turn on, tune in, drop out");
        l.add("I am the Lord your God");
        l.add("Don't copy your neighbours");
        l.add("Are you behind on your credit card bills? Good. Pick up the phone and start dialing.");
        l.add("Is your landlord ready to evict you? Good. Pick up the phone and start dialing.");
    }

}
