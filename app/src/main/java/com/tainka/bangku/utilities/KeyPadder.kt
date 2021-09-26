package com.tainka.bangku.utilities

object KeyPadder {

    fun padKey(key : String) : String
    {
        var returnValue = key
        var firstByte = returnValue[0].code % 64
        while(returnValue.length < 16)
        {
            firstByte = circularShift(firstByte, if(firstByte % 2 == 0) "RIGHT" else "LEFT", (firstByte + 1) % 8) % 64
            returnValue += code(firstByte)
        }
        return returnValue
    }

    private fun circularShift(value : Int, direction : String, step : Int) : Int
    {
        return when (direction) {
            "LEFT" -> {
                (value shl step) or (value shr (8-step)) % 256
            }
            "RIGHT" -> {
                (value shr step) or (value shl (8-step)) % 256
            }
            else -> {
                0
            }
        }
    }

    private fun code(codeKey : Int) : Char
    {
        return when (codeKey) {
            in 0..26 -> {
                ('A'.code + codeKey).toChar()
            }
            in 27..52 -> {
                ('a'.code + codeKey - 27).toChar()
            }
            in 53..62 -> {
                ('0'.code + codeKey - 53).toChar()
            }
            else -> {
                '_'
            }
        }
    }
}