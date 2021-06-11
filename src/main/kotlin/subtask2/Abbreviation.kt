package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        var resString = ""

        var posInA = 0
        for ( charB in b ) {

            while ( posInA < a.length ) {

                if ( charB == a[posInA] || charB == a[posInA].toUpperCase() ) {
                    resString = resString + a[posInA].toUpperCase()
                    posInA++
                    break
                }
                posInA++
            }
        }

        if ( b ==  resString)
            return "YES"
        else
            return "NO"

    }
}
