//測試資料區
// var Json = [{
//     StoreName: '麥當勞-復興二店',
//     Distance: 900,
//     PriceID: 2,
//     Coordinate: [25.0256908, 121.5436333],
//     Address: '台北市大安區復興南路二段273號'
// }, {
//     StoreName: '榕樹下小吃店',
//     Distance: 110,
//     PriceID: 1,
//     Coordinate: [25.034036, 121.544113],
//     Address: '台北市大安區復興南路一段321號'
// }, {
//     StoreName: '朝天鍋餐廳',
//     Distance: 180,
//     PriceID: -1,
//     Coordinate: [25.0323989, 121.543897],
//     Address: '台北市大安區復興南路二段17之1號'
// }, {
//     StoreName: '吉野家大安店',
//     Distance: 80,
//     PriceID: 2,
//     Coordinate: [25.0330046, 121.5434221],
//     Address: '台北市大安區復興南路二段4號'
// }, {
//     StoreName: '無名麵店',
//     Distance: 140,
//     PriceID: -1,
//     Coordinate: [25.0329451, 121.5445399],
//     Address: '台北市大安區信義路四段30巷2號'
// }, {
//     StoreName: '鐵板熱炒',
//     Distance: 280,
//     PriceID: 1,
//     Coordinate: [25.033023, 121.545833],
//     Address: '台北市大安區信義路四段60-42號'
// }, {
//     StoreName: '麥當勞-復興二店',
//     Distance: 900,
//     PriceID: 2,
//     Coordinate: [25.0256908, 121.5436333],
//     Address: '台北市大安區復興南路二段273號'
// }, {
//     StoreName: '榕樹下小吃店',
//     Distance: 110,
//     PriceID: 1,
//     Coordinate: [25.034036, 121.544113],
//     Address: '台北市大安區復興南路一段321號'
// }, {
//     StoreName: '朝天鍋餐廳',
//     Distance: 180,
//     PriceID: -1,
//     Coordinate: [25.0323989, 121.543897],
//     Address: '台北市大安區復興南路二段17之1號'
// }, {
//     StoreName: '吉野家大安店',
//     Distance: 80,
//     PriceID: 2,
//     Coordinate: [25.0330046, 121.5434221],
//     Address: '台北市大安區復興南路二段4號'
// }, {
//     StoreName: '無名麵店',
//     Distance: 140,
//     PriceID: -1,
//     Coordinate: [25.0329451, 121.5445399],
//     Address: '台北市大安區信義路四段30巷2號'
// }, {
//     StoreName: '鐵板熱炒',
//     Distance: 280,
//     PriceID: 1,
//     Coordinate: [25.033023, 121.545833],
//     Address: '台北市大安區信義路四段60-42號'
// }]



console.log(Json);
var J = JSON.stringify(Json);
var FinObj = JSON.parse(J);


//List相關(放在RestList的Block中)
//createElement方法，兩層結構
function InsertList() {
    for (let i = 0; i < FinObj.length; i++) {
        var newList = document.createElement('div');
        newList.setAttribute('class', 'List');
        newList.setAttribute('id', 'jsBorn');
        var newBlock1 = document.createElement('div');
        newBlock1.setAttribute('class', 'Block1');
        newBlock1.innerHTML = '<a href="https://www.google.com.tw/maps/place/' + FinObj[i].Address + '/@' + FinObj[i].Coordinate + ',18z">' + FinObj[i].StoreName + '</a>';
        var newBlock2 = document.createElement('div');
        newBlock2.setAttribute('class', 'Block2');
        newBlock2.appendChild(document.createTextNode(FinObj[i].Distance));
        newList.appendChild(newBlock1);
        newList.appendChild(newBlock2);
        document.getElementById('RestList').append(newList);

    }

}

InsertList();