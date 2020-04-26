package com.example.stickerview.Model

class Person {
    var name:String?=null
    var position:String?=null
    var viewType: Int=0

    constructor()
    constructor(name:String,position:String,viewType:Int){
        this.name = name
        this.position = position
        this.viewType = viewType

    }


}