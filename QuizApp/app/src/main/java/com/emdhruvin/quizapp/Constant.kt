package com.emdhruvin.quizapp

object Constant {
    const val userName: String = "user_name"   //pass the username to another activity
    const val totalQuestions: String =
        "total_question"    //pass number of question to another activity
    const val correctAnswers: String =
        "correct_answer"    //pass number of correct answer to another activity

    fun getQuestions(): ArrayList<Question> { //a function that return question for application
        val questionsList = ArrayList<Question>() //array list of question
        //question 1
        val que1 =
            Question(1, "'10110' is binary of ____?", "22", "20", "10", "16", 1)//created question 1
        questionsList.add(que1)

        //question 2
        val que2 = Question(
            2,
            "Which field of an Ethernet frame provides receiver clock synchronization?",
            "Preamble",
            "SFG",
            "Type",
            "FCS",
            1
        )    //created question 2
        questionsList.add(que2)

        //question 3
        val que3 = Question(
            3,
            "How long is the physical address of a network device?",
            "32 bytes",
            "32bits",
            "48 bytes",
            "48 bits",
            4
        )    //created question 3
        questionsList.add(que3)

        //question 4
        val que4 = Question(
            4,
            "Which field of an Ethernet frame does a switch use to populate its MAC\n" +
                    "address table?",
            "Preamble",
            "Length",
            "Source MAC Address",
            "Destination MAC Address",
            3
        )  //created question 4
        questionsList.add(que4)

        //question 5
        val que5 = Question(
            5,
            "What is the OUI of this MAC address? E8BA.7011.2874",
            "E8BA",
            "E8BA.70",
            "7011",
            "E8BA.7011",
            2
        )    //created question 5
        questionsList.add(que5) //add each question to question list

        //question 6
        val que6 = Question(
            6,
            "What kind of frame does a switch flood out of all interfaces except the one\n" +
                    "it was received on?",
            "Unknown Unicast",
            "Known Unicast",
            "Allcast",
            "Broadcast",
            1
        )
        questionsList.add(que6)

        //question 7
        val que7 = Question(
            7,
            "You send a 36-byte ping to another computer and perform a packet capture to analyze the network traffic. You notice a long series of bytes of 00000000 at the end of the Ethernet payload. How can you explain these zeroes?",
            "Ping are a series of zeros",
            "They are padding bytes",
            "They are the ethernet FCS",
            "NOTA",
            2
        )  //created question 7
        questionsList.add(que7)

        //question 8
        val que8 = Question(
            8,
            "Which fields are present in the output of the show mac address-table command on a Cisco switch?",
            "MAC Address, Ports",
            "VLAN, MAC Address, Types, Ports",
            "VLAN, MAC Address, Types, Ports",
            "Internet Address, Types, Ports",
            3
        )  //created question 8
        questionsList.add(que8)

        //question 9
        val que9 = Question(
            9,
            "Which types of frames does a switch send out of all interfaces, except the one the frame was received on?",
            "Broadcast, Unknown Unicast",
            "Broadcast, Known Unicast",
            "Known Unicast, Unknown Unicast",
            "Broadcast,  Unknown Unicast, Known Unicast",
            1
        )
        questionsList.add(que9) //created question 9

        //question 10
        val que10 = Question(
            10,
            "Which command is used on a cisco switch  to clear all dynamic MAC addresses on a specific interface from the MAC address table",
            "clear mac address-table interface interface-id",
            "clear mac-address-table dynamic interface interface-id",
            "clear mac-address table dynamic interface interface-id",
            "clear mac address-table dynamic interface interface-id",
            4
        )  //created question 10
        questionsList.add(que10)

        return questionsList
    }
}