var zad5 = db.people.aggregate(
    [
        { $unwind : "$credit" },
        { $match : { sex : "Female", nationality : "Poland"}},
        {$group : { _id : "$credit.currency", avgBalance : {$avg : "$credit.balanceFloat"}, sumBalance : {$sum : "$credit.balanceFloat"}}}
    ]
)
zad5.forEach(printjson);    