package finalproject;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Words {
    
    private Random rand = new Random();

    private ArrayList<String> Passages = new ArrayList<>();
    public static ArrayList<String> correctionFacility = new ArrayList<>();
    {
        try {
            for (String word : database.getMisspelledWords(signInFrame.username.getText().trim()))
                correctionFacility.add(word);
        } catch (Exception e){
        }
    }
    private Map<String, Integer> mispelledWord = new HashMap<>();
    
    private String passage = "";
    private int count = 0;
    
    public String [] getPassage(){
        
        String[] words = {
            "raise ", "pitch ", "rugby ", "basis ", "union ", "shoot ", "ivory ", "slice ", "obese ", "admit ",
            "title ", "sugar ", "grass ", "punch ", "touch ", "watch ", "alive ", "trial ", "voice ", "pluck ",
            "lobby ", "scrap ", "lease ", "blast ", "fault ", "tiger ", "smart ", "stain ", "heart ", "plant ",
            "virus ", "organ ", "spite ", "moral ", "cabin ", "tract ", "salon ", "check ", "storm ", "snake ",
            "agony ", "spare ", "order ", "fence ", "bland ", "begin ", "stake ", "value ", "cruel ", "wrong ",
            "basin ", "grind ", "wound ", "enjoy ", "creep ", "front ", "eagle ", "board ", "noble ", "widen ",
            "relax ", "offer ", "creed ", "queue ", "plant ", "march ", "weave ", "handy ", "order ", "wheel ",
            "score ", "giant ", "black ", "trial ", "video ", "slump ", "crack ", "slice ", "serve ", "arena ",
            "brain ", "straw ", "child ", "swing ", "sword ", "acute ", "death ", "faint ", "tower ", "enter ",
            "cause ", "knife ", "apple ", "marsh ", "flood ", "unity ", "shame ", "beard ", "flock ", "charm ",
            "essay ", "total ", "noise ", "pound ", "color ", "chief ", "spoil ", "sleep ", "visit ", "entry ",
            "large ", "shift ", "error ", "round ", "scale ", "robot ", "stock ", "strip ", "grand ", "shark ",
            "linen ", "glove ", "fault ", "order ", "pitch ", "throw ", "grief ", "brick ", "peace ", "trade ",
            "drop ", "have ", "rest ", "glue ", "hole ", "time ", "step ", "sink ", "coat ", "duck ",
            "crew ", "bean ", "mild ", "soul ", "care ", "code ", "rack ", "jail ", "star ", "aids ",
            "flat ", "desk ", "menu ", "mill ", "skip ", "well ", "main ", "mars ", "game ", "edge ",
            "sofa ", "dead ", "lump ", "even ", "lean ", "girl ", "seal ", "axis ", "word ", "will ",
            "node ", "tidy ", "kill ", "easy ", "rank ", "sand ", "dash ", "myth ", "joke ", "late ",
            "wind ", "fist ", "cage ", "keep ", "bare ", "dorm ", "jury ", "hair ", "hate ", "iron ",
            "bean ", "inch ", "mail ", "sock ", "vein ", "lane ", "meal ", "nose ", "aunt ", "suit ",
            "growth ", "latest ", "poetry ", "ballet ", "suntan ", "ignite ", "carbon ", "length ", "charge ", "resist ",
            "polish ", "memory ", "bronze ", "stitch ", "defend ", "writer ", "aspect ", "extend ", "carrot ", "timber ",
            "bottle ", "prince ", "powder ", "murder ", "museum ", "suburb ", "sleeve ", "reason ", "finish ", "player ",
            "europe ", "deputy ", "medium ", "flight ", "marine ", "labour ", "factor ", "attack ", "grudge ", "junior ",
            "barrel ", "sample ", "turkey ", "pastel ", "shadow ", "appear ", "shiver ", "likely ", "flavor ", "winner ",
            "weight ", "helmet ", "season ", "viable ", "bucket ", "source ", "ribbon ", "clique ", "efflux ", "sector ",
            "dealer ", "breast ", "tongue ", "lawyer ", "policy ", "danger ", "ethics ", "shower ", "volume ", "repeat ",
            "drawer ", "candle ", "devote ", "animal ", "hammer ", "wonder ", "inject ", "squash ", "pepper ", "unique ",
            "cinema ", "tumble ", "reform ", "change ", "string ", "finger ", "freeze ", "estate ", "crutch ", "height ",
            "pocket ", "switch ", "coffin ", "extort ", "patrol ", "notion ", "vacuum ", "expand ", "impact ", "regret "
        };
        
        for (int i = 0; i < 100; i++) {
            int position = rand.nextInt(230);
            if (i == 99)
                    words[position] = words[position].trim();
            Passages.add(words[position]);
        }
        
        String [] newWords = new String [Passages.size()];
        
        for (int i = 0; i < Passages.size(); i++) {
            newWords[i] = Passages.get(i);
        }
        
        return newWords;     
    }
    
    public String [] getPassageWithPun(){
        
        String[] words = {
            "raise, ", "pitch ", "rugby, ", "basis ", "union ", "shoot ", "ivory ", "slice, ", "obese ", "admit ",
            "title ", "sugar, ", "grass ", "punch ", "touch ", "watch ", "alive ", "trial ", "voice ", "pluck ",
            "lobby ", "scrap ", "lease! ", "blast ", "fault ", "tiger ", "smart ", "stain ", "heart ", "plant ",
            "virus ", "organ ", "spite ", "moral ", "cabin ", "tract. ", "salon ", "check ", "storm ", "snake ",
            "agony ", "spare ", "order ", "fence ", "bland, ", "begin ", "stake ", "value ", "cruel ", "wrong ",
            "basin ", "grind ", "wound ", "enjoy ", "creep ", "front ", "eagles' ", "board ", "noble, ", "widen ",
            "brain ", "straw ", "child ", "swing ", "sword ", "acute ", "death ", "faint, ", "tower ", "enter ",
            "cause ", "knife ", "apple. ", "marsh ", "flood ", "unity ", "shame ", "beard ", "flock ", "charm ",
            "essay ", "total. ", "noise ", "pound ", "color ", "chief ", "spoil ", "sleep ", "visit ", "entry ",
            "large ", "shift, ", "error ", "round ", "scale ", "robot, ", "stock ", "strip ", "grand? ", "shark ",
            "linen ", "glove ", "fault ", "order ", "pitch ", "throw. ", "grief ", "brick ", "peace ", "trade ",
            "drop? ", "have ", "rest ", "glue ", "hole ", "time ", "step ", "sink ", "coat ", "duck ",
            "crew ", "bean ", "mild ", "soul ", "care ", "code ", "rack ", "jail ", "star ", "aids ",
            "flat ", "desk ", "menu ", "mill ", "skip ", "well ", "main ", "mars ", "game ", "edge ",
            "sofa ", "dead ", "lump ", "even ", "lean, ", "girl ", "seal ", "axis ", "word ", "will ",
            "node ", "tidy ", "kill ", "easy ", "rank! ", "sand ", "dash ", "myth ", "joke ", "late ",
            "wind ", "fist ", "cage ", "keep ", "bare ", "dorm ", "jury ", "hair ", "hate ", "iron ",
            "bean, ", "inch ", "mail ", "sock ", "vein ", "lane ", "meal ", "nose ", "aunt ", "suit ",
            "growth ", "latest ", "poetry ", "ballet ", "suntan ", "ignite ", "carbon ", "length ", "charge ", "resist ",
            "polish, ", "memory ", "bronze, ", "stitch ", "defend ", "writer ", "aspect ", "extend ", "carrot ", "timber ",
            "bottle ", "prince ", "powder ", "murder ", "museum ", "suburb ", "sleeve ", "reason ", "finish ", "player ",
            "europe ", "deputy ", "medium, ", "flight ", "marine ", "labour ", "factor ", "attack ", "grudge ", "junior ",
            "barrel ", "sample ", "turkey ", "pastel ", "shadow ", "appear ", "shiver ", "likely ", "flavor ", "winner ",
            "weight ", "helmet ", "season ", "viable ", "bucket ", "source, ", "ribbon ", "clique ", "efflux ", "sector ",
            "dealer ", "breast ", "tongue, ", "lawyer ", "policy ", "danger ", "ethics ", "shower ", "volume ", "repeat ",
            "drawer ", "candle ", "devote ", "animal ", "hammer ", "wonder ", "inject ", "squash ", "pepper ", "unique ",
            "cinema ", "tumble ", "reform ", "change ", "string ", "finger! ", "freeze ", "estate ", "crutch ", "height ",
            "pocket ", "switch, ", "coffin ", "extort ", "patrol ", "notion ", "vacuum ", "expand ", "impact ", "regret "
        };
        
        for (int i = 0; i < 100; i++) {
            int position = rand.nextInt(230);
            if (i == 99)
                    words[position] = words[position].trim();
            Passages.add(words[position]);
        }
        
        String [] newWords = new String [Passages.size()];
        
        for (int i = 0; i < Passages.size(); i++) {
            newWords[i] = Passages.get(i);
        }
        
        return newWords;

    }
    
    public String [] getWord(int a){
        
        String[] words = {
            "raise ", "pitch ", "rugby ", "basis ", "union ", "shoot ", "ivory ", "slice ", "obese ", "admit ",
            "title ", "sugar ", "grass ", "punch ", "touch ", "watch ", "alive ", "trial ", "voice ", "pluck ",
            "lobby ", "scrap ", "lease ", "blast ", "fault ", "tiger ", "smart ", "stain ", "heart ", "plant ",
            "virus ", "organ ", "spite ", "moral ", "cabin ", "tract ", "salon ", "check ", "storm ", "snake ",
            "agony ", "spare ", "order ", "fence ", "bland ", "begin ", "stake ", "value ", "cruel ", "wrong ",
            "score ", "giant ", "black ", "trial ", "video ", "slump ", "crack ", "slice ", "serve ", "arena ",
            "brain ", "straw ", "child ", "swing ", "sword ", "acute ", "death ", "faint ", "tower ", "enter ",
            "cause ", "knife ", "apple ", "marsh ", "flood ", "unity ", "shame ", "beard ", "flock ", "charm ",
            "essay ", "total ", "noise ", "pound ", "color ", "chief ", "spoil ", "sleep ", "visit ", "entry ",
            "large ", "shift ", "error ", "round ", "scale ", "robot ", "stock ", "strip ", "grand ", "shark ",
            "linen ", "glove ", "fault ", "order ", "pitch ", "throw ", "grief ", "brick ", "peace ", "trade ",
            "drop ", "have ", "rest ", "glue ", "hole ", "time ", "step ", "sink ", "coat ", "duck ",
            "crew ", "bean ", "mild ", "soul ", "care ", "code ", "rack ", "jail ", "star ", "aids ",
            "flat ", "desk ", "menu ", "mill ", "skip ", "well ", "main ", "mars ", "game ", "edge ",
            "sofa ", "dead ", "lump ", "even ", "lean ", "girl ", "seal ", "axis ", "word ", "will ",
            "node ", "tidy ", "kill ", "easy ", "rank ", "sand ", "dash ", "myth ", "joke ", "late ",
            "wind ", "fist ", "cage ", "keep ", "bare ", "dorm ", "jury ", "hair ", "hate ", "iron ",
            "bean ", "inch ", "mail ", "sock ", "vein ", "lane ", "meal ", "nose ", "aunt ", "suit ",
            "growth ", "latest ", "poetry ", "ballet ", "suntan ", "ignite ", "carbon ", "length ", "charge ", "resist ",
            "polish ", "memory ", "bronze ", "stitch ", "defend ", "writer ", "aspect ", "extend ", "carrot ", "timber ",
            "bottle ", "prince ", "powder ", "murder ", "museum ", "suburb ", "sleeve ", "reason ", "finish ", "player ",
            "europe ", "deputy ", "medium ", "flight ", "marine ", "labour ", "factor ", "attack ", "grudge ", "junior ",
            "barrel ", "sample ", "turkey ", "pastel ", "shadow ", "appear ", "shiver ", "likely ", "flavor ", "winner ",
            "weight ", "helmet ", "season ", "viable ", "bucket ", "source ", "ribbon ", "clique ", "efflux ", "sector ",
            "dealer ", "breast ", "tongue ", "lawyer ", "policy ", "danger ", "ethics ", "shower ", "volume ", "repeat ",
            "drawer ", "candle ", "devote ", "animal ", "hammer ", "wonder ", "inject ", "squash ", "pepper ", "unique ",
            "cinema ", "tumble ", "reform ", "change ", "string ", "finger ", "freeze ", "estate ", "crutch ", "height ",
            "pocket ", "switch ", "coffin ", "extort ", "patrol ", "notion ", "vacuum ", "expand ", "impact ", "regret "
        };

        
        if (a == 10) {
            for (int i = 0; i < 10; i++) {
                int position = rand.nextInt(230);
                if (i == 9) 
                    words[position] = words[position].trim();
                Passages.add(words[position]);
            }
        }
        else if (a == 25) {
            for (int i = 0; i < 25; i++) {
                int position = rand.nextInt(230);
                if (i == 24)
                    words[position] = words[position].trim();
                Passages.add(words[position]);
            }
        }
        else if (a == 50) {
            for (int i = 0; i < 50; i++) {
                int position = rand.nextInt(230);
                if (i == 49)
                    words[position] = words[position].trim();
                Passages.add(words[position]);
            }
        }
        else {
            for (int i = 0; i < 100; i++) {
                int position = rand.nextInt(230);
                if (i == 99)
                    words[position] = words[position].trim();
                Passages.add(words[position]);
            }
        }
        
        String [] newWords = new String [Passages.size()];
        
        for (int i = 0; i < Passages.size(); i++) {
            newWords[i] = Passages.get(i);
        }
        
        return newWords;
    } 
    
    public void getIncorrect(String a){
        correctionFacility.add(a + " ");
    }
    
    public int sizeCorrectioin(){
        return correctionFacility.size();
    }
    
    public String [] getCorrectFacility(int b){
        
        String [] newWords;
                
        if (b == 0) {
            newWords = new String [100];
            for (int i = 0; i < newWords.length; i++) {
                int position = rand.nextInt(correctionFacility.size());
                newWords[i] = correctionFacility.get(position);
            }
        }
        else if (b == 10) {
            newWords = new String [10];
            for (int i = 0; i < newWords.length; i++) {
                int position = rand.nextInt(correctionFacility.size());
                newWords[i] = correctionFacility.get(position);
            }
        }
        else if (b == 25) {
            newWords = new String [25];
            for (int i = 0; i < newWords.length; i++) {
                int position = rand.nextInt(correctionFacility.size());
                newWords[i] = correctionFacility.get(position);
            }
        }
        else {
            newWords = new String [50];
            for (int i = 0; i < newWords.length; i++) {
                int position = rand.nextInt(correctionFacility.size());
                newWords[i] = correctionFacility.get(position);
            }
        }
    
        
        newWords[newWords.length-1] = newWords[newWords.length-1].trim();
        
        return newWords;
    }
    
    public String getQuote(){
        
        try(BufferedReader input = new BufferedReader(new FileReader("quote.txt"))){
            String line;
            while ((line = input.readLine()) != null){
                Passages.add(line);
            }
            input.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        int position = rand.nextInt(Passages.size());
        String [] newWords = Passages.get(position).split(" ");
        
        for (String a : newWords){
            passage += a + " ";
        }
        
        return passage;
    }
    
     public String[] mostMispelledWord(){
        
        String [] mostMispelled = new String [correctionFacility.size()];
        for (int i = 0; i < mostMispelled.length; i++) 
            mostMispelled[i] = correctionFacility.get(i);
        
        for (String word : mostMispelled) 
            mispelledWord.put(word, mispelledWord.getOrDefault(word, 0) + 1);
        
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(mispelledWord.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int count = 0;
        ArrayList <String> top10Mispelled = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (correctionFacility.size() > 10) {
                if (count < 10) {
                    top10Mispelled.add(entry.getKey());
                    count++;
                }
                else
                    break;
            } 
            else {
                if (count < correctionFacility.size()) {
                    top10Mispelled.add(entry.getKey());
                    count++;
                }
                else
                    break;
            }
        }
        
        String mispelled_word = "";
        
        for (String word : top10Mispelled) 
            mispelled_word += word;

        return mispelled_word.trim().split(" ");
    }
    
    public void clearPassage(){
        Passages.clear();
        passage = "";
        while (correctionFacility.size() > 50) {
            int position = rand.nextInt(correctionFacility.size());
            correctionFacility.remove(position);
        }
    }
    
}
