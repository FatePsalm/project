$(document).ready(function(){
	doGetEcharts();
	
});
function doGetEcharts(){
		var url="echarts/doecharts.do";
		$.post(url,function(result){
			console.log(result);
			doGetEchart(result.xList,result.data,result.Count);
			doGetEchart1(result.xList,result.data,result.Count);
			doGetEchart2(result.Count);
			doGetEchart3(result.Count);
			doGetEchart4(result.Count);
		});
}
/**维修件统计饼型图*/
function doGetEchart(Xlist,data,sum){
	var dom = document.getElementById("echarts");
	$('#breadcrumbId').html(sum+'条');
	var myChart = echarts.init(dom);
	var app = {};
	option = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			x : 'left',
			data :Xlist
		},
		series : [ {
			name : '维修件记录',
			type : 'pie',
			radius : [ '50%', '70%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '10',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : data
		} ]
	};

	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}
function doGetEchart1(Xlist,data,sum){
	var dom = document.getElementById("echarts1");
	$('#breadcrumbId1').html(sum+'条');
	var myChart = echarts.init(dom);
	var app = {};
	option = {
		    title : {
		        subtext: '维修统计',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: Xlist
		    },
		    series : [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:data,
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};

	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}
function doGetEchart2(sum){
	var dom = document.getElementById("echarts2");
	$('#breadcrumbId2').html('共计'+sum+'条维修记录');
	var myChart = echarts.init(dom);
	var app = {};
	app.title = '极坐标系下的堆叠柱状图';

	option = {
	    angleAxis: {
	    },
	    radiusAxis: {
	        type: 'category',
	        data: ['周一', '周二', '周三', '周四'],
	        z: 10
	    },
	    polar: {
	    },
	    series: [{
	        type: 'bar',
	        data: [1, 2, 3, 4],
	        coordinateSystem: 'polar',
	        name: 'A',
	        stack: 'a'
	    }, {
	        type: 'bar',
	        data: [2, 4, 6, 8],
	        coordinateSystem: 'polar',
	        name: 'B',
	        stack: 'a'
	    }, {
	        type: 'bar',
	        data: [1, 2, 3, 4],
	        coordinateSystem: 'polar',
	        name: 'C',
	        stack: 'a'
	    }],
	    legend: {
	    	x : 'left',
	    	orient: 'vertical',
	        show: true,
	        data: ['A', 'B', 'C']
	    }
	};
	
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}
function doGetEchart4(sum){
	var dom = document.getElementById("echarts4");
	$('#breadcrumbId4').html('共计'+sum+'条维修记录');
	var myChart = echarts.init(dom);
	var app = {};
	option = {
		    title: {
		        text: '一天用电量分布',
		        subtext: '纯属虚构'
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross'
		        }
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis:  {
		        type: 'category',
		        boundaryGap: false,
		        data: ['00:00', '01:15', '02:30', '03:45', '05:00', '06:15', '07:30', '08:45', '10:00', '11:15', '12:30', '13:45', '15:00', '16:15', '17:30', '18:45', '20:00', '21:15', '22:30', '23:45']
		    },
		    yAxis: {
		        type: 'value',
		        axisLabel: {
		            formatter: '{value} W'
		        },
		        axisPointer: {
		            snap: true
		        }
		    },
		    visualMap: {
		        show: false,
		        dimension: 0,
		        pieces: [{
		            lte: 6,
		            color: 'green'
		        }, {
		            gt: 6,
		            lte: 8,
		            color: 'red'
		        }, {
		            gt: 8,
		            lte: 14,
		            color: 'green'
		        }, {
		            gt: 14,
		            lte: 17,
		            color: 'red'
		        }, {
		            gt: 17,
		            color: 'green'
		        }]
		    },
		    series: [
		        {
		            name:'用电量',
		            type:'line',
		            smooth: true,
		            data: [300, 280, 250, 260, 270, 300, 550, 500, 400, 390, 380, 390, 400, 500, 600, 750, 800, 700, 600, 400],
		            markArea: {
		                data: [ [{
		                    name: '早高峰',
		                    xAxis: '07:30'
		                }, {
		                    xAxis: '10:00'
		                }], [{
		                    name: '晚高峰',
		                    xAxis: '17:30'
		                }, {
		                    xAxis: '21:15'
		                }] ]
		            }
		        }
		    ]
		};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}
function doGetEchart3(sum){
	var dom = document.getElementById("echarts3");
	$('#breadcrumbId3').html('共计'+sum+'条维修记录');
	var myChart = echarts.init(dom);
	var app = {};
	var dataAxis = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
	var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];
	var yMax = 500;
	var dataShadow = [];

	for (var i = 0; i < data.length; i++) {
	    dataShadow.push(yMax);
	}

	option = {
	    title: {
	        text: '特性示例：渐变色 阴影 点击缩放',
	        subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
	    },
	    xAxis: {
	        data: dataAxis,
	        axisLabel: {
	            inside: true,
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        axisTick: {
	            show: false
	        },
	        axisLine: {
	            show: false
	        },
	        z: 10
	    },
	    yAxis: {
	        axisLine: {
	            show: false
	        },
	        axisTick: {
	            show: false
	        },
	        axisLabel: {
	            textStyle: {
	                color: '#999'
	            }
	        }
	    },
	    dataZoom: [
	        {
	            type: 'inside'
	        }
	    ],
	    series: [
	        { // For shadow
	            type: 'bar',
	            itemStyle: {
	                normal: {color: 'rgba(0,0,0,0.05)'}
	            },
	            barGap:'-100%',
	            barCategoryGap:'40%',
	            data: dataShadow,
	            animation: false
	        },
	        {
	            type: 'bar',
	            itemStyle: {
	                normal: {
	                    color: new echarts.graphic.LinearGradient(
	                        0, 0, 0, 1,
	                        [
	                            {offset: 0, color: '#83bff6'},
	                            {offset: 0.5, color: '#188df0'},
	                            {offset: 1, color: '#188df0'}
	                        ]
	                    )
	                },
	                emphasis: {
	                    color: new echarts.graphic.LinearGradient(
	                        0, 0, 0, 1,
	                        [
	                            {offset: 0, color: '#2378f7'},
	                            {offset: 0.7, color: '#2378f7'},
	                            {offset: 1, color: '#83bff6'}
	                        ]
	                    )
	                }
	            },
	            data: data
	        }
	    ]
	};

	// Enable data zoom when user click bar.
	var zoomSize = 6;
	myChart.on('click', function (params) {
	    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
	    myChart.dispatchAction({
	        type: 'dataZoom',
	        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
	        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
	    });
	});
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}
