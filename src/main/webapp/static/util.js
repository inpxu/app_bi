/* 处理数据 */
export default {
  listData(type, tableData, dimension, numberValue) {
    let data = null;
    if (tableData.length) {
      switch (type) {
        case 'table':
          data = this.setTableData(tableData, dimension, numberValue);
          break;
        case 'card':
          data = this.setCardData(tableData, dimension, numberValue);
          break;
        case 'gauge':
          data = this.setCardData(tableData, dimension, numberValue);
          break;
        case 'pie':
          data = this.setPieData(tableData, dimension, numberValue);
          break;
          // case 'sunburst':
          //   data = this.setSunburstData(tableData, dimension, numberValue);
          //   break;
        case 'funnel':
          data = this.setPieData(tableData, dimension, numberValue);
          break;
        case 'radar':
          data = this.setRadarData(tableData, dimension, numberValue);
          break;
        case 'line':
          data = this.setLineData(tableData, dimension, numberValue);
          break;
        case 'scatter':
          data = this.setLineData(tableData, dimension, numberValue);
          break;
        case 'bar':
          data = this.setLineData(tableData, dimension, numberValue);
          break;
        case 'wordcloud':
          data = this.setWordcloudData(tableData, dimension, numberValue);
          break;
        default:
          break;
      }
    }
    return data
  },
  /* 
  dimension, numberValue的
  name：显示字段，
  prop：对应tableData的key
  */
  setTableData(tableData, dimension, numberValue) {
    let arr = Array.from(new Set([...dimension, ...numberValue]));
    let newArr = arr.map(val => {
      return {
        label: val.name,
        prop: val.prop
      }
    })
    return {
      columns: newArr,
      tableData: tableData
    }
  },
  setCardData(tableData, dimension, numberValue) {
    // 当0个维度，一个数值
    // ----只取tableData第一组数据
    return [{
      name: numberValue[0].name,
      value: tableData[0][numberValue[0].prop]
    }]
  },
  setPieData(tableData, dimension, numberValue) {
    let nameArr = [];
    let valArr = [];
    if (dimension.length) {
      // 当一个维度，一个数值
      // dimension:为name,
      // numberValue:为value
      nameArr = Array.from(new Set(tableData.map(val => val[dimension[0].prop]))); //除重
      valArr = tableData.map(val => {
        return {
          name: val[dimension[0].prop],
          value: val[numberValue[0].prop],
        }
      })
    } else {
      // 当0个维度，多个数值----只取tableData第一组数据
      let arr = [...numberValue];
      nameArr = Array.from(new Set(arr.map(val => val.name))); //除重
      for (let i of arr) {
        valArr.push({
          name: i.name,
          value: tableData[0][i.prop]
        })
      }
    }
    return {
      nameArr: nameArr,
      valArr: valArr
    }
  },
  setWordcloudData(tableData, dimension, numberValue) {
    let arr = [];
    if (dimension.length) {
      // 当一个维度，一个数值
      arr = tableData.map(val => {
        return {
          name: val[dimension[0].prop],
          value: val[numberValue[0].name],
        }
      })
    } else {
      // 当0个维度，多个数值----只取tableData第一组数据
      let legendArr = Array.from(new Set([...numberValue]));
      for (let i of legendArr) {
        arr.push({
          name: i.name,
          value: tableData[0][i.prop]
        })
      }
    }
    return arr
  },
  setLineData(tableData, dimension, numberValue) {
    let nameArr = [],
      xArr = [],
      valArr = [];
    // 2个以下维度,1个或多个数值
    nameArr = Array.from(new Set([...numberValue].map(val => val.name)));
    xArr = Array.from(new Set([...tableData].map(val => val[dimension[0].prop])));
    [...numberValue].forEach(val => {
      let arr = [...tableData].map(v => {
        return {
          x: v[dimension[0].prop],
          value: v[val.prop],
          name: val.name
        }
      })
      valArr.push(arr)
    })
    return {
      nameArr: nameArr,
      xArr: xArr,
      valArr: valArr
    }
  },
  setRadarData(tableData, dimension, numberValue) {
    let nameArr = [],
      valArr = [];
    // 0个维度,1个或多个数值
    [...numberValue].forEach(val => {
      valArr.push({
        name: val.name,
        value: [...tableData].map(v => v[val.prop])
      })
    })
    return valArr
  },
  // setSunburstData(tableData, dimension, numberValue) {
  //   // 2个或多个维度,1个数值---维度靠前的为父级，靠后为子集，最后为数值
  //   let tree = [],
  //     arr = []
  //     mapArr=[];
  //   let flag = [...dimension].findIndex(v => v.prop == numberValue[0].prop)
  //   if (flag != -1) {
  //     let array = [...dimension];
  //     array.splice(flag, 1);
  //     arr = array.concat([...numberValue])
  //   } else {
  //     arr = [...dimension].concat([...numberValue])
  //   }
  //   // 前面是后面的父级
  //   [...tableData].forEach(v=>{
  //     for(let i=0;i<arr.length;i++){
  //       if(i===arr.length){
  //         obj={
  //           name: arr[i].name,
  //           value: v[arr[i].prop],
  //           children: []
  //         }
  //       }
  //       else{
  //         obj={
  //           name: arr[i].name,
  //           children: []
  //         }
  //       }
  //     }
  //   })
  //   return tree
  // },
  // 递归算法
}
