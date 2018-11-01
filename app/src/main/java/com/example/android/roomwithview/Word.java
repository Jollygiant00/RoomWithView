package com.example.android.roomwithview;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String word) {
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }

    @Dao
    public interface WordDao {

        @Insert
        void insert(Word word);

        @Query("DELETE FROM word_table")
        void deleteAll();

        @Query("SELECT * FROM word_table ORDER BY word ASC")
        LiveData<List<Word>> getAllWords();

    }
}
