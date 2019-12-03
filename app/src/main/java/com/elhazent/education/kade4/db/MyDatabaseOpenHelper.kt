package com.elhazent.education.kade4.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.elhazent.education.kade4.model.favorite.FavoriteModel
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "favorite.db", null, 1) {

    companion object {
        private var instace: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instace == null) {
                instace = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instace as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable(
            FavoriteModel.TABLE_FAVORITE, true,
            FavoriteModel.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteModel.EVENT_ID to TEXT + UNIQUE,
            FavoriteModel.HOME_TEAM_ID to TEXT,
            FavoriteModel.AWAY_TEAM_ID to TEXT,
            FavoriteModel.HOME_TEAM_SCORE to TEXT,
            FavoriteModel.AWAY_TEAM_SCORE to TEXT,
            FavoriteModel.HOME_TEAM_NAME to TEXT,
            FavoriteModel.AWAY_TEAM_NAME to TEXT,
            FavoriteModel.EVENT_DATE to TEXT
            )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.dropTable(FavoriteModel.TABLE_FAVORITE, true)
    }
}

val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)