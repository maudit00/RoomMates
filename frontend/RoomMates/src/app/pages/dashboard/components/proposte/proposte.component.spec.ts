import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposteComponent } from './proposte.component';

describe('ProposteComponent', () => {
  let component: ProposteComponent;
  let fixture: ComponentFixture<ProposteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProposteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProposteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
