package com.intuit.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;



public class MusicalPlayUnitTest {
    MusicalPlay musicalPlayInstance;
    @BeforeEach
    void init() {
        musicalPlayInstance = new MusicalPlay();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenNullAndEmptyMusicalPlay_WhenGetMinDeletion_ThenSucceed(String musicalString) {
        //Given
        //When
        //Assertions
        Assertions.assertEquals(-1, musicalPlayInstance.getMinDeletionToMakeGoodPlay(musicalString));
    }


    @ParameterizedTest
    @CsvSource({"aaabbbcccddd,6", "abcdabcdabcd,6", "abcabc,3", "aaabbbcccd,4"})
    void givenCharactersWithEqualFrequency_WhenGetMinDeletion_ThenSucceed(String musicalString, String expectedMinCount) {
        //Given
        //When
        //Assertions
        Assertions.assertEquals(Integer.parseInt(expectedMinCount), musicalPlayInstance.getMinDeletionToMakeGoodPlay(musicalString));
    }


    @ParameterizedTest
    @ValueSource(strings = {"abbcccdddd", "a"})
    void givenCharactersWithUniqueFrequency_WhenGetMinDeletion_ThenSucceed(String musicalString) {
        //Given
        //When
        //Assertions
        Assertions.assertEquals(0, musicalPlayInstance.getMinDeletionToMakeGoodPlay(musicalString));
    }

    @ParameterizedTest
    @CsvSource({"aaabbbcc,2", "bbcebab,2", "abcabc,3"})
    void givenCharacters_WhenGetMinDeletion_ThenSucceed(String musicalString, String expectedMinCount) {
        //Given
        //When
        //Assertions
        Assertions.assertEquals(Integer.parseInt(expectedMinCount), musicalPlayInstance.getMinDeletionToMakeGoodPlay(musicalString));
    }
}
