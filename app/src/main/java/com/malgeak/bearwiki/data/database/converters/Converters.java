package com.malgeak.bearwiki.data.database.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.malgeak.bearwiki.data.model.ingredients.Ingredients;
import com.malgeak.bearwiki.data.model.method.Method;

import java.lang.reflect.Type;
import java.util.List;

public class Converters {

    @TypeConverter
    public static Method fromStringToMethod(String value) {
        return value == null ? null : new Gson().fromJson(value, Method.class);
    }

    @TypeConverter
    public static String methodToString(Method value) {
        return value == null ? null : new Gson().toJson(value);
    }

    @TypeConverter
    public static Ingredients fromStringToIngredients(String value) {
        return value == null ? null : new Gson().fromJson(value, Ingredients.class);
    }

    @TypeConverter
    public static String ingredientsToString(Ingredients value) {
        return value == null ? null : new Gson().toJson(value);
    }

    @TypeConverter
    public static List<String> fromStringToListString(String value) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return value == null ? null : new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String listStringToString(List<String> value) {
        return value == null ? null : new Gson().toJson(value);
    }

}
