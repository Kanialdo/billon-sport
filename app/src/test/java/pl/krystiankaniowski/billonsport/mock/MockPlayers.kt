package pl.krystiankaniowski.billonsport.mock

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating

/**
 * Created by kryst on 22.10.2017.
 */

class Players {

	companion object {

		val data = """
		[
		{
			"_id": "59e68185d8666a7768269191",
			"first_name": "Krystian",
			"last_name": "Kaniowski",
			"nickname": "Kania",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e682cad8666a7768269192",
			"first_name": "Aleksander",
			"last_name": "Włodarczyk",
			"nickname": "Olek",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68352d8666a7768269193",
			"first_name": "Konrad",
			"last_name": "Kuzebski",
			"nickname": "Konrad",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68731d8666a7768269194",
			"first_name": "Michał",
			"last_name": "Kowal",
			"nickname": "Michał Kowal",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68ab2d8666a7768269195",
			"first_name": "Krzysztof",
			"last_name": "Babis",
			"nickname": "Krzysiek",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68acad8666a7768269196",
			"first_name": "Bartosz",
			"last_name": "Lewandowski",
			"nickname": "Bartek",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68ad4d8666a7768269197",
			"first_name": "Michał",
			"last_name": "Przasnyski",
			"nickname": "Przysmaki",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68b66d8666a7768269198",
			"first_name": "Wojciech",
			"last_name": "Komór",
			"nickname": "Wojtas",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68b76d8666a7768269199",
			"first_name": "Michał",
			"last_name": "Maciejewski",
			"nickname": "Maciejka",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68b80d8666a776826919a",
			"first_name": "Edward",
			"last_name": "Słówko",
			"nickname": "Edi",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68b89d8666a776826919b",
			"first_name": "Jacek",
			"last_name": "Pikul",
			"nickname": "Jacek",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68b99d8666a776826919c",
			"first_name": "Kamil",
			"last_name": "Szmit",
			"nickname": "Kamil",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e68ba8d8666a776826919d",
			"first_name": "Patryk",
			"last_name": "Kuć",
			"nickname": "Patryk",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e7831bd8666a776826919e",
			"first_name": "Maciek",
			"last_name": "Ruczko",
			"nickname": "Maciek R",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		},
		{
			"_id": "59e78383d8666a776826919f",
			"first_name": "Michał",
			"last_name": "Kaniowski",
			"nickname": "Mały Kania",
			"rank": 25,
			"rank_x": 8.3,
			"__v": 0
		}
		]
		"""

		fun kania() = Player("1", "Kania", "K", "K", Rating(25f, 8.3f))
		fun konrad() = Player("3", "Kania", "K", "K", Rating(25f, 8.3f))
		fun malyKania() = Player("2", "Maly Kania", "K", "K", Rating(25f, 8.3f))

	}

}
