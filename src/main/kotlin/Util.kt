
fun max(a: Int?, b: Int?): Int {
    return Integer.max(a.toIntNullable(), b.toIntNullable())
}

fun Int?.toIntNullable(): Int {
    return this ?: 0
}
