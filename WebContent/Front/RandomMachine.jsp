<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta name="robots" content="noindex">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>RandomResult</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css"
        integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
        crossorigin="" />
    <script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js"
        integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
        crossorigin=""></script>
    <style>
        @import url("css/RandomMachine.css");
    </style>
</head>

<body>
    <div class="bgheader"> </div>
    <div class="bgimg">
        <div class="fork">
            <img src="pic/fork-05.png" alt="">
        </div>

        <div class="circle">
            <div class="colorless">
                <span id="title">結果</span>
                <div class="form">
                    <div>
                        <div>
                            <p class="tilte2">店家</p>
                            
                        </div>
                        <div class="List" id="List1">
                           
                                <p class="Block1">店家名稱</p>
                            
                           
                                <p class="Block2">距離(m)</p>
                          
                    </div>
                       
                        <div id="RestList">
                       
                              
                        </div>

                    </div>

                    <div id="MapContain">
                        <div>
                            <p class="tilte2">Map</p>
                        </div>
                        <div id="map" class="mapsize">
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="fork">
            <img src="pic/knife-05.png" alt="">
        </div>

    </div>
    <div>
        <div class="bgb">
            <div class="button_padding">
                <div class="button">
                    <p class="title3" onclick="chooseOne()">選出一個</p>
                </div>
            </div>
            <div class="button_padding">
                <div class="button">
                    <p class="title3" onclick="restartRandom()">重新再五個</p>
                </div>
            </div>
            <div class="button_padding">
                <div class="button">
                    <p class="title3" onclick="history.back()"> 返回</p>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">var Json = <%=request.getAttribute("toFront") %>;</script>
    <script type="text/javascript" src="js/RandomMachine.js"></script>
</body>

</html>