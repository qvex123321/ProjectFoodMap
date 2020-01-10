<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta name="robots" content="noindex">
<meta charset="UTF-8">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>ListAll</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <style>
        @import url("css/ListAll.css");
    </style>
</head>

<body>
    <div class="bgheader"> </div>
    <div class="bgimg">

        <div class="circle">
            <div class="colorless">
                <span id="title">結果</span>
                <div class="form">
                    <div>
                        <div>
                            <p class="tilte2">店家</p>

                        </div>
                        <div class="List" id="List1">
                            <div>
                                <p class="Block1">店家名稱</p>
                            </div>
                            <div>
                                <p class="Block2">距離(m)</p>
                            </div>
                        </div>
                        <div id="RestList">



                        </div>

                    </div>

                    <div id="MapContain">
                        <div>
                            <p class="tilte2"></p>
                        </div>
                        <div id="" class="">
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
                    <p class="title3" onclick="history.back()"> 返回</p>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">var Json = <%=request.getAttribute("toFront") %>;</script>
    <script type="text/javascript" src="js/ListAll.js"></script>
</body>

</html>