// //測試資料區
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
// }]
var J = JSON.stringify(Json);
var JObject = JSON.parse(J);

function rollRandomArray(ListLength) { //隨機產生不重覆的n個數字
    let RandomArray = [5]; //儲存產生的陣列
    for (let i = 0; i < 5; i++) {
        let randomitem = 0; //暫存的亂數
        let exist;
        do {
            exist = false; //此亂數是否已存在
            randomitem = Math.floor(Math.random() * ListLength);
            //檢查亂數是否存在於陣列中，若存在則繼續
            if (RandomArray.indexOf(randomitem) != -1) exist = true;
        } while (exist); //產生沒出現過的亂數時離開迴圈

        RandomArray[i] = randomitem;
    }
    return RandomArray;
}

function getFinObj(JObject) {
    //取得亂數後的五個object(有含判斷有無超過五個)
    if (JObject.length < 5) {
        return JObject;
    } else {
        let RandomArray = rollRandomArray(JObject.length);

        let FinObj = [JObject[RandomArray[0]], JObject[RandomArray[1]],
            JObject[RandomArray[2]], JObject[RandomArray[3]],
            JObject[RandomArray[4]]
        ];
        return FinObj;
    }
}

//上面是亂數取得的區域(請直接呼叫getFinObj(JObject))
//FinObj為亂數後的陣列
var FinObj = getFinObj(JObject);

//取得最大距離
function mixDistance() {
    let mixDist = 0;
    for (let i = 0; i < FinObj.length; i++) {
        if (FinObj[i].Distance > mixDist) {
            mixDist = FinObj[i].Distance;
        }
    }
    return mixDist;
}
//地圖相關
function mapFunction() {
    //控制初始地圖大小用
    let mixDist = mixDistance();
    if (mixDist <= 300) {
        var map = L.map('map').setView([25.0335852, 121.5431327], 15);
    } else if (mixDist > 300 && mixDist < 600) {
        var map = L.map('map').setView([25.0335852, 121.5431327], 14);
    } else {
        var map = L.map('map').setView([25.0335852, 121.5431327], 13);
    }

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '<a href="https://www.openstreetmap.org/">OpenStreetMap</a>',
        maxZoom: 18,
    }).addTo(map);

    for (let i = 0; i < FinObj.length; i++) {
        L.marker(FinObj[i].Coordinate, { title: FinObj[i].StoreName }).addTo(map);
    }
}

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
        console.log(document.getElementById('RestList'));
        document.getElementById('RestList').append(newList);

    }

}

//選出一個按鈕
function chooseOne() {
    //亂數將其中一個抓出來
    var j = Math.floor(Math.random() * FinObj.length);
    FinObj = [FinObj[j]];
    //清除頁面
    cleanPage();
    //插入新的List與地圖
    InsertList();
    mapFunction();
}
//五選一按鈕
function restartRandom() {
    //重新骰List
    FinObj = getFinObj(JObject);
    //清除頁面
    cleanPage();
    //插入新的List與地圖
    InsertList();
    mapFunction();
}
//清除頁面，給chooseOne()及restartRandom()兩個function用的
function cleanPage() {
    //清除List
    let jB = document.getElementsByClassName('List');
    document.getElementById('RestList').innerHTML = "";
    //直接把全部MAP作掉重新裝
    document.getElementById('map').remove();
    var newMap = document.createElement('div');
    newMap.setAttribute('class', 'mapsize');
    newMap.setAttribute('id', 'map');
    document.getElementById('MapContain').append(newMap);
}


InsertList();
mapFunction();