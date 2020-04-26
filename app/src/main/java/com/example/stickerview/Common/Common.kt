package com.example.stickerview.Common

import com.example.stickerview.Model.Person
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

object Common {
    val VIEWTYPE_GROUP = 0
    val VIEWTYPE_PERSONS = 1
    val RESULT_CODE = 1000

    var alphabet_available:MutableList<String> = ArrayList()


    fun sortList(list:ArrayList<Person>):ArrayList<Person>{
        list.sortWith(Comparator{
            person1,person2 -> person1!!.name!!.compareTo(person2!!.name!!)
        })
        return list
    }

    fun addAlphabet(list:ArrayList<Person>):ArrayList<Person>{
        var i : Int = 0
        val customList = ArrayList<Person>()
        val firstMember = Person()
        firstMember.name = list[0].name!![0].toString()
        firstMember.viewType = VIEWTYPE_GROUP
        alphabet_available.add(list[0].name!![0].toString())
        customList.add(firstMember)
        i=0
        while(i<list.size-1){
            val person = Person()
            val name1 = list[i].name!![0]
            val name2 = list[i+1].name!![0]
            if(name1 == name2){
                list[i].viewType = VIEWTYPE_PERSONS
                customList.add(list[i])
            }
            else {
                list[i].viewType = VIEWTYPE_PERSONS
                customList.add(list[i])
                person.name = name2.toString()
                person.viewType = VIEWTYPE_GROUP
                alphabet_available.add(name2.toString())
                customList.add(person)
            }
            i++
        }
        list[i].viewType = VIEWTYPE_PERSONS
        customList.add(list[i])
        return customList





    }


    fun findPositionWithName(name:String,list:ArrayList<Person>):Int{
        for(i in list.indices)
            if(list[i].name == name)
                return i
        return -1
    }

    fun genAlphabetLIst():ArrayList<String>{
        val result = ArrayList<String>()
        for(i in 65..90)
            result.add((i.toChar()).toString())
        return result


    }

    fun geNPersonGrojup():ArrayList<Person>{
        val personList = ArrayList<Person>()

        var person = Person("Oluwaseun","Convener",-1)
        personList.add(person)
         person = Person("Daniel","Manager",-1)
        personList.add(person)
         person = Person("Tomisin","CTO",-1)
        personList.add(person)
         person = Person("Tunde","CEO",-1)
        personList.add(person)
         person = Person("Toluwanimi","Chief Auditor",-1)
        personList.add(person)
         person = Person("Feyi","PRO",-1)
        personList.add(person)
         person = Person("Dolapo","Lead Designer",-1)
        personList.add(person)
         person = Person("Betsy","Regional Manager",-1)
        personList.add(person)
         person = Person("Tobiloba","Frontend Engineer",-1)
        personList.add(person)
         person = Person("Yemi","Mobile Engineer",-1)
        personList.add(person)
         person = Person("Seye","Backend Engineer",-1)
        personList.add(person)
         person = Person("Ayo","Intern",-1)
        personList.add(person)
         person = Person("Thanos","Bouncer",-1)
        personList.add(person)
         person = Person("Tomilola","Marketing Manager",-1)
        personList.add(person)
         person = Person("Damilola","Cloud Engineer",-1)
        personList.add(person)
        return personList
    }




}