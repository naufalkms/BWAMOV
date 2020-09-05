package com.bagicode.bwamov.sign.signin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
    var email:String ?="",
    var nama:String ?="",
    var password:String ?="",
    var url:String ?="",
    var usernamae:String ?="",
    var saldo:String ?=""
) : Parcelable