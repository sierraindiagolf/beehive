import { Directive, ElementRef, Input, OnInit } from '@angular/core';
import {Hive} from "./hive";
import * as d3 from '../custom-d3';

@Directive({
  selector: '[bhHive]'
})
export class BhHiveDirective implements OnInit {
  ngOnInit(): void {
    var framesGroup = this.element.nativeElement.querySelector('g.frames');
    var selection = d3.select(framesGroup).selectAll('use').data(this.hive.bodies);
    selection.enter()
      .append('use')
      .attr('xlink:href', '#frame')
      .merge(selection)
      .attr('x', function(d, index) {
        return index * 41;
      });

    selection.exit().remove();
  }

  //private hiveModel: any;
  @Input('bhHive') hive: Hive;
  private element: ElementRef;

  constructor(el: ElementRef) {
    this.element = el;
  }
}
