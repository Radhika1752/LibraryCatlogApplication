import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-filter',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './filter.component.html',
  styleUrl: './filter.component.css'
})
export class FilterComponent {

  @Input() all:number=0;
  @Input() premium:number=0;
  @Input() paid:number=0;
  @Input() free:number=0;


  selectButtonValue:String="all";
  //creating a user defined event
  @Output()
  filterRadioButtonSelectionValue:EventEmitter<String>=new EventEmitter();

  //create a method that is going to raise the event(filterRadioButtonSelectionValue)
  onRadioButtonChage()
  {
    this.filterRadioButtonSelectionValue.emit(this.selectButtonValue);
    console.log(this.selectButtonValue);
  }

}

