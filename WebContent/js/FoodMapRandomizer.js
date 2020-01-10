  // 全選按鈕
function chooseAll() {
    var checkStyles = document.getElementsByName('foodStyle');
    for (let i = 0; i < checkStyles.length; i++) {
        let checkStyle = checkStyles[i];
        checkStyle.checked = 'checked';
    }
}
//全不選按鈕
function killAll() {
    var checkStyles = document.getElementsByName('foodStyle');
    for (let i = 0; i < checkStyles.length; i++) {
        let checkStyle = checkStyles[i];
        checkStyle.checked = null;
    }
}

//下面是如果正餐才會出現類型選項
function showType() {
    var styleDisplay = document.getElementById("checkboxArea");
    styleDisplay.style = "visibility: visible";
    chooseAll();
}
function hideType() {
    var styleDisplay = document.getElementById("checkboxArea");
    styleDisplay.style = "visibility: hidden";
    killAll();
}

//取得的資料並轉成Json檔案
function getchoose() {
    let number = parseInt(document.getElementsByName("number")[0].value);
    let priceID = parseInt(document.getElementsByName("price")[0].value);
    let walkTime = parseInt(document.getElementsByName("walkTime")[0].value);

    let foodTypes = document.getElementsByName("foodType");
    let foodType;
    for (let i = 0; i < foodTypes.length; i++) {
        if (foodTypes[i].checked) {
            foodType = parseInt(foodTypes[i].value);
        }
    }
    //   多選要用迴圈抓
    let foodStyles = document.getElementsByName("foodStyle");
    let foodStyle = []
    for (let i = 0; i < foodStyles.length; i++) {
        if (foodStyles[i].checked) {
            foodStyle.push(parseInt(foodStyles[i].value));
        }
    }
    //轉成object
    var ToBack = {
        'number' : number,
        'priceID': priceID,
        'walkTime': walkTime,
        'foodType': foodType,
        'foodStyle': foodStyle,
    }
    return ToBack;
}

function checkSubmit() {
    //使用getchoose()，取得ToBack元素來做檢查
    var ToBack = getchoose();
    if ((ToBack.foodType === 0) && (ToBack.foodStyle.length === 0)) {
        alert("請至少選擇一種類型");
    } else {
        //轉成JSON
        var chooseArray = JSON.stringify(ToBack);
        //要傳至後端的指令碼可以放這裡
        console.log(chooseArray);
        document.getElementById("toSubmit").value = chooseArray;
        document.forms["hiddenForm"].submit();
    }
    console.log(document.getElementById("toSubmit").value);
}