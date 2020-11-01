import java.io.File
import kotlin.math.log2

fun main() {
    val set = mutableSetOf<String>()
    var str = ""
    for (i in 100..999) {
        if (i.toString()[0] == i.toString()[1] && i.toString()[0] != i.toString()[2]) {
            set.add(i.toString())
        }
        if (i.toString()[0] == i.toString()[2] && i.toString()[0] != i.toString()[1]) {
            set.add(i.toString())
        }
        if (i.toString()[1] == i.toString()[2] && i.toString()[1] != i.toString()[0]) {
            set.add(i.toString())
        }
    }
    print(set)
    print(set.count())
    val map_elem = mutableMapOf<Int?, MutableList<String>>()
    val map = sortedMapOf<Int, Int?>()
    set.forEach() {
        val key = it[0].toInt() - it[1].toInt()
        if (map.containsKey(key)) {
            map[key] = map[key]?.plus(1)
        } else {
            map += Pair(key, 1)
        }
    }
    set.forEach(){
        val key = it[0].toInt() - it[1].toInt()
        if (map_elem.containsKey(key)) {
            map_elem[key]?.add(it)
        } else {
            map_elem+=Pair(key, mutableListOf())
            map_elem[key]?.add(it)
        }
    }
    println()
    print(map_elem.values)
    println()
    print(map)
    File("fileName123").printWriter().use { out ->
        map.forEach(){out.println("${it.key}${if(it.key<0)  "" else  " "} == ${it.value}${if(it.value!! >=10)  "" else  " "}  ${map_elem[it.key]}")}
    }
    var t: Double = 0.0
    map.forEach() {
        t += (it.value!!.toDouble() / 243) * log2((1 / (it.value!!.toDouble() / 243)))
    }
    println()
    println(t)
    val map1 = mutableMapOf<Int?, Int?>()
    set.forEach() {
        val key = it[1].toInt() - it[2].toInt()
        if (map1.containsKey(key)) {
            map1[key] = map1[key]?.plus(1)
        } else {
            map1 += Pair(key, 1)
        }
    }
    println()
    print(map1)
    var t1: Double = 0.0
    map1.forEach() {
        t1 += (it.value!!.toDouble() / 243) * log2((1 / (it.value!!.toDouble() / 243)))
    }
    println()
    println(t1)
    var t12: Int=0
    println(
        {
         map_elem.forEach{ it ->
             it.value.forEach(){it2 ->
                 if(it2[2].toInt()==9) t12++}
         }
        t12.toString()})
    println(t12)


var count =0
    map_elem.forEach(){it->
        it.value.forEach(){value->
            val ttt = value[2].toInt() - 48
            //println(value[2])
            //println(ttt)
            //println(ttt == 0)
            if(ttt==9) count++
        }
        print(count)
    }
    println()
    println(map_elem)
    val H = mutableMapOf<Int,MutableList<Double>>()
    map.forEach(){
        for(i in -8..9) {
            var temp = mutableListOf<Double>()
            var cnt = 0
            for (j in 0..9) {
                map_elem[i]?.forEach() { value ->

                    if (value[2].toInt() - 48 == j) {
                        cnt++
                    }
                }
                //val t123 = cnt.toDouble()/map_elem[i]?.size!!
                temp.add(j, (cnt.toDouble()/ map_elem[i]?.size!!).toDouble())
                cnt =0;
            }
            H+=Pair(i,temp)
        }
    }
    println()
    println()
    println(map_elem[-8]?.size)
    println(H)
    var summ = 0.0
    var temp_summ = 0.0
    H.forEach(){
        it.value.forEach(){value->
            if(value !=0.0) {temp_summ+= value*log2(1/value)}
            summ+=temp_summ*(map_elem[it.key]?.size!!.toDouble())/243.0
            temp_summ =0.0
        }
    }
    println(summ)
    var s = (18.0/243.0)*log2(243.0/18.0) + (9*25.0/243.0)*log2(243.0/25.0)
    println(s)

    val H_t = mutableMapOf<Int,MutableList<Double>>()
    map.forEach(){
        for(i in -8..9) {
            var temp = mutableListOf<Double>()
            var cnt = 0
            for (j in -8..9) {
                map_elem[i]?.forEach() { value ->

                    if ((value[0].toInt() - 48) - (value[2].toInt() -48) == j) {
                        cnt++
                    }
                }
                //val t123 = cnt.toDouble()/map_elem[i]?.size!!
                temp.add(j+8, (cnt.toDouble()/ map_elem[i]?.size!!).toDouble())
                cnt =0;
            }
            H_t+=Pair(i,temp)
        }
    }
    println(H_t)
    var summ_t = 0.0
    var temp_summ_t = 0.0
    H_t.forEach(){
        it.value.forEach(){value->
            if(value !=0.0) {temp_summ_t+= value*log2(1/value)}
            summ_t+=temp_summ_t*(map_elem[it.key]?.size!!.toDouble())/243.0
            temp_summ_t =0.0
        }
    }
    println(summ_t)
}

