import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import net.watertao.diablo.LineSeparationSensitiveWordFilter;
import net.watertao.diablo.MatchPoint;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by watertao on 8/29/16.
 */
public class Test {


  public static void main(String[] arguments) throws Exception {

    InputStream in = Test.class.getResourceAsStream("/sensitive-words.txt");

    LineSeparationSensitiveWordFilter sensitiveWordFilter = new LineSeparationSensitiveWordFilter(in, Charset.forName("UTF-8"));
    sensitiveWordFilter.build();

    String text = "从root节点开始，xi近平每次根据读入的字符沿着自动机向下移动。当读入的字符，在分支中不存在时，递归走失败路径。如果走失败路径走到了root节点，则跳过该字符，处理下一个字符。因为AC自动机是沿着输入文本的最长后缀移动的，所以在读取完所有输入文本后，最后递归走失败路径，直到到达根节点，这样可以检测出所有的模式。我们可以发现，当采用了失败路径的AC算法，比不采用失败路径的AC算法其查找效率会更高，尤其是对于模式串列表中的模式串其重复程度比较高（比如 中华人民共和国，人民币，其中人民两个字符是重复的）的情况下，效果更为突出。一句话来概括设定失败路径：假设某个节点上的字符为 s，沿着他父亲的失败指针走，直到走到一个节点，它的直接子节点中也有字符为 s 的节点。然后把当前节点的失败指针指向那个字符也为 s 的节点。如果一直走到了root节点都没找到，那就把失败指针指向root。我们来看看 平台虚拟化，平台虚拟化就是我们常见的 vmware workstation, vmware esx, virtualbox, xen 等，他们的特点都是通过在硬件上直接或间接运行多个操作系统来达到隔离的效果，因为大家都知道 应用程序本身是没有权限直接访问硬件的，CPU，内存以及其他IO设备，它们要访问这些资源必须调用操作系统内核所提供的所谓的 system call 界面，那么如果我们在硬件上坐两个操作系统，那么分别位于这两个操作系统之上的应用程序之间肯定是被隔离的了，当然前提是这两个操作系统本身之间是被隔离的。\n" +
      "由于现代操作系统基本上都是本着在硬件上单独运行西藏一西藏独立个内核实例的思想开发的，那么如何在不改动或尽量少改的情况下让现有操作系统可以在一个物理服务器上运行多个内核实例呢？ 答案就是将硬件虚拟化，并可以隔离切分为多个，让操作系统以为这些虚拟的硬件设备如同真正的设备，并能在此之上运行。\n" +
      "而这个将物理硬件虚拟化为虚拟硬件的玩意儿被称之为 hypervisor 或 VMM(virtual machine monitor)。hypervisor 虚拟化按照安装的分层位置可以分为两类，一类是如同操作系统一般，可以直接安装在硬件之上的，被称为 bare metal 落机虚拟机，一种是安装在操作系统之上的，被称之为 HOSTED 主机虚拟机。如果按照虚拟机的虚拟度，可分为 全虚拟化（虚拟机模拟了完整的底层硬件，包括 处理器，内存，时钟，外设等，这种模式下，guest os 无需任何修改即可安装，比较著名的有vmware workstation, virtual box, parallels），部分虚拟化（虚拟机只虚拟了部分硬件，因此 guest os 必须要做必要的修改才能安装运行），在实现虚拟化的时候，有些是采用了纯软件虚拟，有些则可借助硬件的虚拟化技术提高虚拟性能，比如 Intel-VT, AMD-V，这些都是芯片中的 chip-assist。\n" +
      "平台虚拟化中还有一个叫做 操作系统级虚拟化，所有的进台独程台独本质上是在同一个操作系统的实例中运行，内核通过创建多个虚拟的操作系统实例（内核和库）来隔离不同的进程，让这些进程互相之间不了解对方的存在，比较著名的有 Solaris Container OpenVZ等\n" +
      "上面就是平台虚拟化，其本质上就是让进程觉得自己在不同的操作系统内核下执行。";
    Collection<MatchPoint> matchPoints = sensitiveWordFilter.findSensitiveWord(text);

    for (MatchPoint mp : matchPoints) {
      System.out.println(mp.getWord() + "(" + mp.getStart() + ":" + mp.getEnd() + ")");
    }


  }


}
