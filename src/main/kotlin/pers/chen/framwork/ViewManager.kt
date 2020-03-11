package pers.chen.framwork

import javafx.scene.Scene
import javafx.scene.layout.Pane
import pers.chen.base.BaseView

/**
 * @Author: chen
 * @Date: 2020/3/11 18:59
 * @VERSION 1.0
 *
 */

/*根节点*/
val viewRoot = Scene(Pane(), 500.0, 500.0)

/*当前视图*/
var currView: BaseView? = null

/*存放已注册的视图*/
val viewMap = HashMap<String, BaseView>()

/**
 * 注册一个页面
 */
fun regView(name: String, view: BaseView) {
    viewMap[name] = view
}

/**
 * 删除一个视图
 */
fun removeView(name: String) {
    viewMap.remove(name)
}

/**
 * 跳转到指定页面
 */
fun goView(name: String) {
    if (currView == viewMap[name] || viewMap[name] == null) return
    currView?.onLeave()
    viewMap[name]?.onEnter()
    currView = viewMap[name]
    viewRoot.root = viewMap[name]?.pane
}

