function mapFunc() 
{
    for(i = 0; i < this.credit.length; i++)
    {
        var item = this.credit[i];
        emit(item.currency, parseFloat(item.balance));
    }
}

function reduceFunc(key, value)
{
    var array = value.filter(x => !isNaN(x));
    return Array.sum(array)
}
db.people.mapReduce(mapFunc, reduceFunc, { out : 'out2' })

var zad2 = db.out2.find({});

zad2.forEach(printjson);