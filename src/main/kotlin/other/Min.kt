package other

import java.lang.IllegalArgumentException

/**
 * нахождение минимального значения из списка
 * @T - тип элемента списка
 */
class Min<T : Comparable<T>> {

    /**
     * возвращает минимальный элемент из списка
     *
     * @items - список элементов
     */
    fun compute(items: List<T>) : T {
        if (items.isEmpty()) {
            throw IllegalArgumentException("items is empty!")
        }
        var min = items[0]
        for (i in 1 until items.size) {
            if (min > items[i]) {
                min = items[i]
            }
        }
        return min
    }

}