var zad3 = db.people.aggregate(
    [
        {$group : { _id : "job", jobs : {"$addToSet" : "$job"}}}
    ]
);

zad3.forEach(printjson);    