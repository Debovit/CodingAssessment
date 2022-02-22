package com.intuit.music;

public class MusicalInstrument {
    private final MusicalPlay musicalPlayInstance;
    MusicalInstrument(MusicalPlay musicalPlayInstance) {
        this.musicalPlayInstance = musicalPlayInstance;
    }

    public void getMinRemovals(String musicalPlayString) {
        int minDeletionCount = this.musicalPlayInstance.getMinDeletionToMakeGoodPlay(musicalPlayString);
        if (minDeletionCount == -1) {
            System.out.println(Constants.INVALID_INPUT);
        } else {
            System.out.println("Min deletions to make it a good play : " + minDeletionCount);
        }
    }
}
