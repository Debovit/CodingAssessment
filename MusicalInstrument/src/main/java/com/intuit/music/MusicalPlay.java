package com.intuit.music;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MusicalPlay {
    //Time Complexity - O(26N) = O(N) - Max 26 alphabets can be there in the string, we would iterate through each character's frequency - N
//Space Complexity - O(26) = O(1) - If there are 26 alphabets in the input string then we need to store all the characters in the map
    public int getMinDeletionToMakeGoodPlay(String musicalString) {
        //Base case when the musicalPlay is null or contains only whitespace characters
        if (musicalString == null || musicalString.isEmpty()) return -1;
        return getMinDeletionCount(getCharacterFrequencyMap(musicalString));
    }

    private int getMinDeletionCount(Map<Character, Integer> characterFrequencyMap) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        //Iterate through the frequency map
        for (Map.Entry<Character, Integer> characterFrequency : characterFrequencyMap.entrySet()) {
            //Character with unique frequency - store it in the set
            //and then in the next run check it against the set
            if (!set.contains(characterFrequency.getValue())) {
                set.add(characterFrequency.getValue());
            } else {
                //Character frequency already present in the set
                int frequency = characterFrequency.getValue();
                //Keep on decrementing and check whether the frequency is already
                //present in the set, if yes add it if the character frequency count is more than 0
                //at each decrement, increment the count
                while (set.contains(frequency)) {
                    frequency--;
                    count++;
                }
                if (frequency > 0) {
                    set.add(frequency);
                }
            }
        }
        return count;
    }

    private Map<Character, Integer> getCharacterFrequencyMap(String musicalPlay) {
        //Create a frequencyMap to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        //Iterate through the string and if the character is already present in the map
        //increment the character's frequency by 1.
        for (int i = 0; i < musicalPlay.length(); i++) {
            if (frequencyMap.containsKey(musicalPlay.charAt(i))) {
                frequencyMap.put(musicalPlay.charAt(i), frequencyMap.get(musicalPlay.charAt(i)) + 1);
            } else {
                frequencyMap.put(musicalPlay.charAt(i), 1);
            }
        }
        return frequencyMap;
    }
}
