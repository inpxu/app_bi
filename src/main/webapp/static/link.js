// 处理联动筛选问题
export default{
    linkParam(key,config){
        let data = null;
        let dimension=config.dataConfig.dimension.map(v=>v.prop);
        let numberValue=config.dataConfig.numberValue.map(v=>v.prop)
        switch (config.chart) {
        //   case 'table':
            
        //     break;
        //   case 'card':
     
        //     break;
          case 'gauge':
              
            break;
          case 'pie':

            break;

          case 'funnel':

            break;
          case 'radar':

            break;
          case 'line':
   
            break;
          case 'scatter':
   
            break;
          case 'bar':
      
            break;
          case 'wordcloud':
            
            break;
          default:
            break;
        }
        return data
    }
}