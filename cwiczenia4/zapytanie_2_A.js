var zad2 = db.people.aggregate(
    [
        {$unwind : "$credit" },
        {$group : { _id : "$credit.currency", avgBalance : {$avg : "$credit.balanceFloat"}}}
    ]
);
zad2.forEach(printjson);    