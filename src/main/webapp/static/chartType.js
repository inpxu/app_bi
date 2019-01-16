/**
 * 定义图表的种类与图片
 * type---图表类型
 * chart---图表类型下的图表种类
 * isAxis---是否显示坐标轴样式跟缩放组件
 * isVisualMap---图表根据数据变色
 * isAble----a维度，b数值
 */
export const types = (a, b) => {
  return [{
      type: "table",
      chart: 'table', // 表格
      name: '表格',
      icon: "icon-biaoge",
      content1: "不限",
      content2: "",
      isAble: a.length > 0 || b.length > 0
    }, {
      type: "card",
      chart: 'card', // 卡片
      name: '卡片',
      icon: "icon-qiapian",
      content1: "0维度",
      content2: "1个数值",
      isAble: a.length == 0 && b.length == 1
    }, {
      type: "chart",
      chart: 'pie', // 饼图
      name: '饼图',
      isAxis: false,
      isVisualMap: false,
      icon: "icon-zuixinICON--",
      content1: "1个维度,1个数值",
      content2: " 0维度,多数值",
      isAble: (a.length == 1 && b.length == 1) || (a.length == 0 && b.length > 0)
    },
    // {
    //   type: "chart",
    //   chart: 'sunburst', // 旭日图
    //   name: '旭日图',
    //   isAxis: false,
    //   isVisualMap: true,
    //   icon: "icon-xuritu",
    //   content1: "1个维度,1个数值",
    //   content2: " 0维度,多数值",
    //   isAble: (a.length >= 2 && b.length == 1)
    // },
    {
      type: "chart",
      chart: 'gauge', // 仪表盘
      name: '仪表盘',
      isAxis: false,
      isVisualMap: false,
      icon: "icon-yibiaopan",
      content1: "0维度",
      content2: "1个数值",
      isAble: a.length == 0 && b.length == 1
    },
    {
      type: "chart",
      chart: 'funnel', // 漏斗图
      name: '漏斗图',
      isAxis: false,
      isVisualMap: false,
      icon: "icon-loudoutu",
      content1: "1个维度,1个数值",
      content2: " 0维度,多数值",
      isAble: (a.length == 1 && b.length == 1) || (a.length == 0 && b.length > 0)
    },
    {
      type: "chart",
      chart: 'radar', // 雷达图
      name: '雷达图',
      isAxis: false,
      isVisualMap: true,
      icon: "icon-leidatu",
      content1: " 0维度,多数值",
      content2: " ",
      isAble: (a.length == 0 && b.length > 0)
    },
    // {
    //   type: "chart",
    //   chart: 'graph', // 关系图
    //   name: '关系图',
    //   isAxis: false,
    //   isVisualMap: true,
    //   icon: "icon-guanxitu",
    // },
    {
      type: "chart",
      chart: 'bar', // 柱状图
      name: '柱状图',
      isAxis: true,
      isVisualMap: true,
      icon: "icon-tubiaozhuzhuangtu",
      content1: "2个以下维度",
      content2: "1个或多个数值",
      isAble: a.length == 1 && b.length >= 1
    },
    {
      type: "chart",
      chart: 'line', // 折线图
      name: '折线图',
      isAxis: true,
      isVisualMap: true,
      icon: "icon-zhexiantu",
      content1: "2个以下维度",
      content2: "1个或多个数值",
      isAble: a.length == 1 && b.length >= 1
    },
    {
      type: "chart",
      chart: 'scatter', // 散点图
      name: '散点图',
      isAxis: true,
      isVisualMap: true,
      icon: "icon-sandiantu",
      content1: "2个以下维度",
      content2: "1个或多个数值",
      isAble: a.length == 1 && b.length >= 1
    },
    {
      type: "chart",
      chart: 'wordcloud', // 字符云
      name: '字符云',
      icon: "icon-zujian-zifuyun",
      content1: "1个维度,1个数值",
      content2: " 0维度,多数值",
      isAble: (a.length == 1 && b.length == 1) || (a.length == 0 && b.length > 0)
    },
    // {
    //   type: "chart",
    //   chart: 'liquidfill', // 水球图
    //   name: '水球图',
    //   icon: "icon-fsux_tubiao_shuiqiutu",
    // },
    // {
    //   type: "map",
    //   chart: 'map', // 地图
    //   name: '地图',
    //   icon: "icon-map_02",
    // }
  ];
}
